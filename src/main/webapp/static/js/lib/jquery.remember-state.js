(function($) {
  /* jQuery form remember state plugin
     Name: rememberState
     Version: 1.1
     Description: When called on a form element, localStorage is used to
     remember the values that have been input up to the point of either
     saving or unloading. (closing window, navigating away, etc.) If
     localStorage isn't available, nothing is bound or stored.
     The plugin looks for an element with a class of remember_state to show
     a note indicating there is stored data that can be repopulated by clicking
     on the anchor within the remember_state container. If the element doesn't
     exist, it is created and prepended to the form.
     Usage: $("form").rememberState("my_object_name");
     Notes: To trigger the deletion of a form's localStorage object from
     outside the plugin, trigger the reset_state event on the form element
     by using $("form").trigger("reset_state");
  */
  $.fn.rememberState = function(defaults) {
    var opts = $.extend({
          clearOnSubmit: true,
          noticeDialog: (function() {
            var $e = $("<p />", {"class": "remember_state"})
                     .html('Do you want to <a href="#">restore your previously entered info</a>?');
            return $e;
          })(),
          noticeSelector: ".remember_state",
          objName: false }, defaults);
    var use_ids = !(!!opts.objName);
    if (!("prop" in $.fn)) { $.fn.prop = $.fn.attr; }
    if (opts.noticeDialog.length && typeof opts.noticeDialog === "object") {
      opts.noticeDialog.find("a").bind("click.remember_state", function(e) {
        var data = getObject(opts.objName),
            $f = $(this).closest("form"),
            $e;
        for (var i in data) {
          $e = $f.find("[name=\"" + data[i].name + "\"]");
          if ($e.is(":radio, :checkbox")) {
            $e.filter("[value=" + data[i].value + "]").prop("checked", true);
          }
          else if ($e.is("select")) {
            $e.find("[value=" + data[i].value + "]").prop("selected", true);
          }
          else { $e.val(data[i].value); }
        }
        opts.noticeDialog.remove();
        e.preventDefault();
      });
    }
    if (this.length > 1) {
      if (console.log) {
        console.log("WARNING: Cannot process more than one form with the same" +
          " object. Attempting to use form IDs instead.");
      }
      use_ids = true;
    }
    return this.each(function() {
      var $form = $(this);
      if (use_ids) {
        if ($form.attr("id")) {
          opts.objName = $form.attr("id");
        }
        else {
          if (console.log) {
            console.log("ERROR: No form ID or object name. Add an ID or pass" +
              " in an object name");
            return this;
          }
        }
      }
      if (localStorage[opts.objName]) {
        (opts.noticeDialog.length && typeof opts.noticeDialog === "object") ?
          opts.noticeDialog.prependTo($form) :
          $form.find(opts.noticeSelector).show();
      }
      $form.bind("reset_state", function() {
        delete localStorage[opts.objName];
      });
      if (opts.clearOnSubmit) {
        $form.bind("submit.remember_state", function() {
          $(this).trigger("reset_state");
        });
      }
      var onUnload = function() {
        var values = $form.serializeArray();
        // jQuery doesn't currently support datetime-local inputs despite a
        // comment by dmethvin stating the contrary:
        // http://bugs.jquery.com/ticket/5667
        // Manually storing input type until jQuery is patched
        $form.find("input[type='datetime-local']").each(function() {
          var $i = $(this);
          values.push({ name: $i.attr("name"), value: $i.val() });
        });
        setObject(opts.objName, values);
      };
      $(window).bind("unload.remember_state", onUnload);
      if (!$.support.cssFloat) {
        window.onbeforeunload = onUnload;
        $.fn.rememberState.unload = onUnload;
      }
      $form.find(":reset").bind("click.remember_state", function() {
        $(this).closest("form").trigger("reset_state");
      });
    });
  };
  function setObject(key, value) { this[key] = JSON.stringify(value); };
  function getObject(key) { return JSON.parse(this[key]); };
})(jQuery);

if (!("localStorage" in window) || !("sessionStorage" in window)) {
  (function() {
    var Storage = function (type) {
      function createCookie(name, value, days) {
        var date, expires;

        if (days) {
          date = new Date();
          date.setTime(date.getTime()+(days*24*60*60*1000));
          expires = "; expires="+date.toGMTString();
        } else {
          expires = "";
        }
        document.cookie = name+"="+value+expires+"; path=/";
      }

      function readCookie(name) {
        var nameEQ = name + "=",
            ca = document.cookie.split(';'),
            i, c;

        for (i=0; i < ca.length; i++) {
          c = ca[i];
          while (c.charAt(0)==' ') {
            c = c.substring(1,c.length);
          }

          if (c.indexOf(nameEQ) == 0) {
            return c.substring(nameEQ.length,c.length);
          }
        }
        return null;
      }

      function setData(data) {
        data = JSON.stringify(data);
        if (type == 'session') {
          window.name = data;
        } else {
          createCookie('localStorage', data, 365);
        }
      }

      function clearData() {
        if (type == 'session') {
          window.name = '';
        } else {
          createCookie('localStorage', '', 365);
        }
      }

      function getData() {
        var data = type == 'session' ? window.name : readCookie('localStorage');
        return data ? JSON.parse(data) : {};
      }


      // initialise if there's already data
      var data = getData();

      return {
        length: 0,
        clear: function () {
          data = {};
          this.length = 0;
          clearData();
        },
        getItem: function (key) {
          return data[key] === undefined ? null : data[key];
        },
        key: function (i) {
          // not perfect, but works
          var ctr = 0;
          for (var k in data) {
            if (ctr == i) return k;
            else ctr++;
          }
          return null;
        },
        removeItem: function (key) {
          delete data[key];
          this.length--;
          setData(data);
        },
        setItem: function (key, value) {
          data[key] = value+''; // forces the value to a string
          this.length++;
          setData(data);
        }
      };
    };
    if (typeof window.localStorage == 'undefined') window.localStorage = new Storage('local');
    if (typeof window.sessionStorage == 'undefined') window.sessionStorage = new Storage('session');
  })();
}

// if (!window.localStorage) {
//   window.localStorage = {
//     getItem: function (sKey) {
//       if (!sKey || !this.hasOwnProperty(sKey)) { return null; }
//       return unescape(document.cookie.replace(new RegExp("(?:^|.*;\\s*)" + escape(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=\\s*((?:[^;](?!;))*[^;]?).*"), "$1"));
//     },
//     key: function (nKeyId) { return unescape(document.cookie.replace(/\s*\=(?:.(?!;))*$/, "").split(/\s*\=(?:[^;](?!;))*[^;]?;\s*/)[nKeyId]); },
//     setItem: function (sKey, sValue) {
//       if(!sKey) { return; }
//       document.cookie = escape(sKey) + "=" + escape(sValue) + "; path=/";
//       this.length = document.cookie.match(/\=/g).length;
//     },
//     length: 0,
//     removeItem: function (sKey) {
//       if (!sKey || !this.hasOwnProperty(sKey)) { return; }
//       var sExpDate = new Date();
//       sExpDate.setDate(sExpDate.getDate() - 1);
//       document.cookie = escape(sKey) + "=; expires=" + sExpDate.toGMTString() + "; path=/";
//       this.length--;
//     },
//     hasOwnProperty: function (sKey) { return (new RegExp("(?:^|;\\s*)" + escape(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=")).test(document.cookie); },
//     setObject: function(key, value) { this[key] = JSON.stringify(value); },
//     getObject: function(key) { return JSON.parse(this[key]); }
//   };
//   window.localStorage.length = (document.cookie.match(/\=/g) || window.localStorage).length;
// }

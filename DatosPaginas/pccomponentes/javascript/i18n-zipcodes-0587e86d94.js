!function(){function e(i,t,r){function n(d,s){if(!t[d]){if(!i[d]){var u="function"==typeof require&&require;if(!s&&u)return u(d,!0);if(o)return o(d,!0);var a=new Error("Cannot find module '"+d+"'");throw a.code="MODULE_NOT_FOUND",a}var p=t[d]={exports:{}};i[d][0].call(p.exports,function(e){return n(i[d][1][e]||e)},p,p.exports,e,i,t,r)}return t[d].exports}for(var o="function"==typeof require&&require,d=0;d<r.length;d++)n(r[d]);return n}return e}()({1:[function(e,i,t){"use strict";var r=e("./zipRegexLib.js");i.exports=function(e,i){var t,n,o,d;if("string"!=typeof e||"string"!=typeof i)throw"The arguments required are two strings: countryCode, zipCode";if(t=e.trim().toLocaleLowerCase(),n=i.trim(),void 0!==r.uniqueZip[t])o=r.uniqueZip[t];else for(d=0;r.commonZip.countryCode.length>d;d++)if(r.commonZip.countryCode[d].indexOf(t)>-1){o=r.commonZip.pattern[d];break}if(void 0!==o)return o.test(n);throw"No Regex corresponds to this country code"}},{"./zipRegexLib.js":2}],2:[function(e,i,t){"use strict";i.exports={uniqueZip:{ad:/^((AD|ad)[0-9]{3})$/,ar:/^((\d{4})|([a-zA-Z]{1}\d{4}[a-zA-Z]{3}))$/,bm:/^[a-zA-Z]{2}\s\d{2}$/,bn:/^[a-zA-Z]{2}\d{4}$/,br:/^(\d{5})(-\d{3})?$/,ca:/^[ABCEGHJKLMNPRSTVXY]{1}\d{1}[A-Z]{1} *\d{1}[A-Z]{1}\d{1}$/,fo:/^([a-zA-Z]{2}-)?(\d{3})?$/,fr:/^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$/,gb:/^GIR?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]|[A-HK-Y][0-9]([0-9]|[ABEHMNPRV-Y]))|[0-9][A-HJKS-UW])?[0-9][ABD-HJLNP-UW-Z]{2}$/,ge:/^((\d{4})|(\d{6}))$/,ie:/^(([a-zA-Z]{2}(\s(([a-zA-Z0-9]{1})|(\d{2})))?)|([a-zA-Z]{3}))$/,jp:/^\d{3}(-\d{4})?$/,kr:/^\d{3}-\d{3}$/,lv:/^([a-zA-Z]{2}-)?(\d{4})$/,mv:/^\d{4,5}$/,mt:/^[a-zA-Z]{3}\s\d{2,4}$/,nl:/^(\d{4})\s?[a-zA-Z]{2}$/,pl:/^\d{2}(-)?\d{3}$/,pt:/^\d{4}(-)\d{3}$/,sz:/^[a-zA-Z]{1}\d{3}$/,tw:/^\d{3}(\d{2})?$/,us:/^\d{5}(-\d{4})?$/},commonZip:{countryCode:["is|mg".split("|"),"at|au|bd|be|bg|ch|cx|cy|dk|gl|gw|hu|li|lu|md|mk|mz|no|nz|ph|sd|si|tn|ve|xk|za".split("|"),"as|ba|cs|cu|de|dz|ee|es|fi|fm|gf|gp|gt|gu|hr|ic|id|il|it|ke|kw|lt|ma|me|mh|mm|mp|mq|mx|my|pk|pm|pr|ps|pw|re|sa|sm|th|tr|ua|uy|vi|vn|yu|zm".split("|"),"am|az|bj|by|cn|in|kg|kz|mn|ro|rs|ru|sg|tj|tm|uz".split("|"),"cz|gr|se|sk".split("|")],pattern:[/^[0-9]{3}$/,/^[0-9]{4}$/,/^[0-9]{5}$/,/^[0-9]{6}$/,/^[0-9]{3}\s?[0-9]{2}$/]}}},{}],3:[function(e,i,t){(function(i){var t=e("./lib/i18n-zipcodes.js");i.window.i18nZipcodes=t}).call(this,"undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:{})},{"./lib/i18n-zipcodes.js":1}]},{},[3]);
window.pccVideo=function(){$(".iframe-creator[data-src]").each(function(){$(this).data("src")&&function(t){requestAnimationFrame(function(){t.attr("src",t.data("src")),t.removeAttr("data-src")})}($(this))})},$(document).ready(function(){$(window).on("load",function(){pccVideo()})});
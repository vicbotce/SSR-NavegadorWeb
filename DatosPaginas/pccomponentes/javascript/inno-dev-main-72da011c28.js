function resetHelpButton(){$helpPopsUpSearchInput.val(""),$helpPopsUp.fadeOut(400,function(){$helpPopsUpResults.fadeOut(400,function(){$helpPopsUpResultsContent.html("")})}),$teLlamamosForm.add($enviarBtnHolder).fadeOut(400,function(){$defaultHelp.fadeIn(400)})}function generateNotification(e,p){}var $helpPopsUp=$("#helpPopsUp"),$teLlamamosForm=$("#teLlamamosForm"),$helpPopsUpResults=$("#helpPopsUpResults"),$helpsPopsUpTrigger=$("#helpPopsUpTrigger"),$helpPopsUpResultsContent=$("#helpPopsUpResultsContent"),$defaultHelp=$("#defaultHelp"),$enviarBtnHolder=$("#enviarBtnHolder"),$helpPopsUpSearchInput=$("#helpPopsUpSearchInput");$helpPopsUpSearchInput.val("");var pathName=window.location.pathname,pathControl=pathName.split("/");$(function(){"support"!==pathControl[1]?$helpsPopsUpTrigger.fadeIn():$helpsPopsUpTrigger.fadeOut(),$helpsPopsUpTrigger.click(function(){$helpPopsUp.fadeIn(400)}),$(window).on("load",function(){$helpPopsUpSearchInput.on("change",function(){var e=$(this).val();e.length>3?$.ajax({async:!0,url:Routing.generate("pcc_web_support_helpButton_search_ajax"),data:"search="+e,method:"post",dataType:"json",complete:function(e){e.responseJSON.total>0?$helpPopsUpResults.fadeIn(400,function(){$helpPopsUpResultsContent.html(e.responseJSON.html)}):$helpPopsUpResults.fadeOut(400)}}):$helpPopsUpResults.fadeOut(400)}),$("#helpPopsUpClose").click(function(){resetHelpButton()}),$("#tellamamosTrigger").click(function(){$.ajax({url:Routing.generate("pcc_web_support_call2me_helpButton_status"),data:"",method:"post",dataType:"json",complete:function(e){$teLlamamosForm.html(e)}}),$defaultHelp.add($helpPopsUpResults).fadeOut(400,function(){$teLlamamosForm.add($enviarBtnHolder).fadeIn(400,function(){$helpPopsUpResultsContent.html("")})})})})});
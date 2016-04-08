$(document).ready(function(){
$("#SourceNbId").blur(function(){
  
    $.ajax({
       url : 'ClimatisationAjax', 
       type : 'GET',
       dataType : 'text',
       success: function(texte){
    	   $("#nbID").html(texte);
       }
    });
   
});
});

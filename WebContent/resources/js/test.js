$(function() {
     $("#grade").change(function (){
       $("#man").prop('disabled', false);
     });
     
     $("#grade").change(function (){
       if($("#grade").val().trim()=="Manager"){
    	  document.getElementById("man").value = "-";
    		
          $("#man").prop('disabled', true);
       }else{
          $("#man").prop('disabled', false);
       }

     });
  });

$(function() {
    $("#grade").change(function (){
      $("#sup").prop('disabled', false);
    });
    
    $("#grade").change(function (){
      if($("#grade").val().trim()=="Sup"){
   	  document.getElementById("sup").value = "-";
   		
         $("#sup").prop('disabled', true);
      }else{
         $("#sup").prop('disabled', false);
      }

    });
 });












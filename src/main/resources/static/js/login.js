// Call the dataTables jQuery plugin
$(document).ready(function() {

//on ready

});


 async function iniciarSesion(){

 let datos ={};
 datos.correo=document.getElementById("txtCorreo").value;
 datos.password=document.getElementById("txtPassword").value;

  const request = await fetch('login/', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const response = await request.text();

  if(response!='Fail'){
  localStorage.token=response;
  localStorage.email=datos.correo;
  window.location.href='usuarios.html';
  }else{

  alert("Credenciales incorrectas, por favor intente nuevamente")
  }

}

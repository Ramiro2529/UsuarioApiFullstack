// Call the dataTables jQuery plugin
$(document).ready(function() {

//on ready

});


 async function registrarUsuarios(){

 let datos ={};
 datos.nombre=document.getElementById("txtNombre").value;
 datos.apellido=document.getElementById("txtApellido").value;
 datos.correo=document.getElementById("txtCorreo").value;
 datos.celular=document.getElementById("txtCelular").value;
 datos.password=document.getElementById("txtPassword").value;

 let repetirPassword =document.getElementById("txtRepeatPassword").value;

 if (repetirPassword != datos.password){
 alert("La contraseña que escribiste no coincide");
 return;
 }

  const request = await fetch('crearUsuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

alert("La cuenta fue creada con exito");
window.location.href='login.html';
}

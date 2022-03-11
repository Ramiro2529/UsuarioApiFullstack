// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
  actualizarEmailUsuario();


});
function actualizarEmailUsuario(){
document.getElementById('txt-email-usuario').outerHTML=localStorage.email;

}

 async function cargarUsuarios(){

  const request = await fetch('listaUsuarios', {
    method: 'GET',
    headers: getHeaders()
  });

  const usuarios = await request.json();

  console.log(usuarios);
  console.log("R");



let listadoHTML = '';

for (let usuario of usuarios){
let botonEliminar ='<a href="#" onclick="eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a>';

let usuarioHTML = '<tr><td>'+usuario.id+' </td><td>'+usuario.nombre+' '+usuario.apellido +
'</td><td>'+usuario.correo+
' </td> <td>'+usuario.celular+'</td><td>'+ botonEliminar+'</td> </tr>';

listadoHTML+= usuarioHTML;

}





document.querySelector('#usuarios tbody').outerHTML=listadoHTML;

}


function getHeaders(){
return {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
             'Authorization':localStorage.token
           };

}
async function eliminarUsuario(id){
if(!confirm('¿Desea eliminar a este usuario?')){
return;
}

const request = await fetch('borrarPorId/' +id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload();

 }
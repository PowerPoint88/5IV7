//mandamos a llamar a las funciones del tipo de cifrado
function cifrar(){
    var tipo = document.getElementById("tipo").value;
     
    if(tipo=="128"){
        cifrar128()
    }
    if(tipo=="192"){
        cifrar192()
    }
    if(tipo=="256"){
        cifrar256()
    }

}

//Cifrado de 128 AES
function cifrar128(){
    let txt = document.getElementById("txt").value;
    let clave = document.getElementById("clave").value;

    if(clave.length!=16){
        swal("LA CLAVE DEBE MANTENER 16 CARACTERES");
    }else{
        var cifrado = CryptoJS.AES.encrypt(txt, clave);
        document.getElementById("txtcifrado").innerHTML=cifrado;
        descargarArchivo(generarTexto(cifrado), 'CifradoAES-128-'+Math.random()+'.txt');
    }

}

//cifrado de 192 AES
function cifrar192(){
    let txt = document.getElementById("txt").value;
    let clave = document.getElementById("clave").value;

    if(clave.length!=24){
        swal("LA CLAVE DEBE DE TENER 24 CARACTERES");
    }else{
        var cifrado = CryptoJS.AES.encrypt(txt, clave);
        document.getElementById("txtcifrado").innerHTML=cifrado;
        descargarArchivo(generarTexto(cifrado), 'CifradoAES-192-'+Math.random()+'.txt');
    }

}

//cifrado de 256 AES
function cifrar256(){
    let txt = document.getElementById("txt").value;
    let clave = document.getElementById("clave").value;

    if(clave.length!=32){
        swal("LA CLAVE DEBE DE TENER 32 CARACTERES");
    }else{
        var cifrado = CryptoJS.AES.encrypt(txt, clave);
        document.getElementById("txtcifrado").innerHTML=cifrado;
        descargarArchivo(generarTexto(cifrado), 'CifradoAES-256-'+Math.random()+'.txt');
    }

}

//mandamos a llamar a los metodos para descifrar
function descifrar(){
    var tipo = document.getElementById("tipo").value;
     
    if(tipo=="128"){
        descifrar128()
    }
    if(tipo=="192"){
        descifrar192()
    }
    if(tipo=="256"){
        descifrar256()
    }

}

//descifrar tipo 128 AES
function descifrar128(){
    let txt = document.getElementById("txtcifrado").value;
    let clave = document.getElementById("clave").value;

    if(clave.length!=16){
        swal("LA CLAVE DEBE TENER 16 CARACTERES");
    }else{
        var descifrado = CryptoJS.AES.decrypt(txt, clave);
        document.getElementById("txtdescifrado").innerHTML=descifrado.toString(CryptoJS.enc.Utf8);
        descargarArchivo(generarTexto(descifrado.toString(CryptoJS.enc.Utf8)), 'DescifradoAES-128-'+Math.random()+'.txt');
    }

}

//descifrar tipo 192 AES
function descifrar192(){
    let txt = document.getElementById("txtcifrado").value;
    let clave = document.getElementById("clave").value;

    if(clave.length!=24){
        swal("LA CLAVE DEBE TENER 24 CARACTERES");
    }else{
        var descifrado = CryptoJS.AES.decrypt(txt, clave);
        document.getElementById("txtdescifrado").innerHTML=descifrado.toString(CryptoJS.enc.Utf8);
        descargarArchivo(generarTexto(descifrado.toString(CryptoJS.enc.Utf8)), 'DescifradoAES-192-'+Math.random()+'.txt');
    }

}

//descifrar tipo 256 AES
function descifrar256(){
    let txt = document.getElementById("txtcifrado").value;
    let clave = document.getElementById("clave").value;

    if(clave.length!=32){
        swal("LA CLAVE DEBE TENER 32 CARACTERES");
    }else{
        var descifrado = CryptoJS.AES.decrypt(txt, clave);
        document.getElementById("txtdescifrado").innerHTML=descifrado.toString(CryptoJS.enc.Utf8);
        descargarArchivo(generarTexto(descifrado.toString(CryptoJS.enc.Utf8)), 'DescifradoAES-256-'+Math.random()+'.txt');
    }

}


/*Usaremos una funcion parra descargar el archivo, dandole un nombre y generando un texto para la descarga*/
function descargarArchivo(contenidoEnBlob, nombreArchivo) {
    
    var reader = new FileReader();
    
    reader.onload = function (event) {
      
      var save = document.createElement('a');
      save.href = event.target.result;
      save.target = '_blank';
      
      save.download = nombreArchivo;
      var clicEvent = new MouseEvent('click', {
        'view': window,
        'bubbles': true,
        'cancelable': true
      });
      
      save.dispatchEvent(clicEvent);
      
      (window.URL || window.webkitURL).revokeObjectURL(save.href);
    };
    
    reader.readAsDataURL(contenidoEnBlob);
  };

  //generamos el texto que nos ayuda a la descarga
function generarTexto(datos) {
    let texto = [];
    texto.push(datos);

    return new Blob(texto, {
        type: 'text/plain'
    });
};
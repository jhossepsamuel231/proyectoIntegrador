/*----------------Archivo Uno---------------------*/

function validarPdfUno() {
    var archivoInput = document.getElementById('primerArchivo');
   
    validarPdf();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorPrimerArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalUno').modal('show');
    }
}

function validarPdf() {
    var archivoInput = document.getElementById('primerArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}


/*----------------Archivo Dos---------------------*/

function validarPdfDos() {
    var archivoInput = document.getElementById('segundoArchivo');

    validarPdfN2();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorSegundoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalDos').modal('show');
    }
}

function validarPdfN2() {
    var archivoInput = document.getElementById('segundoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}

/*----------------Archivo Tres---------------------*/

function validarPdfTres() {
    var archivoInput = document.getElementById('tercerArchivo');

    validarPdfN3();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorTercerArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalTres').modal('show');
    }
}


function validarPdfN3() {
    var archivoInput = document.getElementById('tercerArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}


/*----------------Archivo Cuatro---------------------*/

function validarPdfCuatro() {
    var archivoInput = document.getElementById('cuartoArchivo');

    validarPdfN4();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorCuartoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalCuatro').modal('show');
    }
}



function validarPdfN4() {
    var archivoInput = document.getElementById('cuartoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}


/*----------------Archivo Cinco---------------------*/

function validarPdfCinco() {
    var archivoInput = document.getElementById('quintoArchivo');

    validarPdfN5();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorQuintoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalCinco').modal('show');
    }
}

function validarPdfN5() {
    var archivoInput = document.getElementById('quintoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}


/*----------------Archivo Seis---------------------*/

function validarPdfSeis() {
    var archivoInput = document.getElementById('sextoArchivo');

    validarPdfN6();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorSextoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalSeis').modal('show');
    }
}

function validarPdfN6() {
    var archivoInput = document.getElementById('sextoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}


/*----------------Archivo Siete---------------------*/

function validarPdfSiete() {
    var archivoInput = document.getElementById('septimoArchivo');

    validarPdfN7();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorSeptimoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalSiete').modal('show');
    }
}

function validarPdfN7() {
    var archivoInput = document.getElementById('septimoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}



/*----------------Archivo Ocho---------------------*/

function validarPdfOcho() {
    var archivoInput = document.getElementById('octavoArchivo');

    validarPdfN8();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorOctavoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalOcho').modal('show');
    }
}

function validarPdfN8() {
    var archivoInput = document.getElementById('octavoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;
    }

}



/*----------------Archivo Nueve---------------------*/

function validarPdfNueve() {
    var archivoInput = document.getElementById('novenoArchivo');

    validarPdfN9();

    if (archivoInput.files && archivoInput.files[0]) {
        var visor = new FileReader();
        visor.onload = function (e) {
            document.getElementById('visorNovenoArchivo').innerHTML =
                    '<embed src="' + e.target.result + '" width="500" height="500" >';

        };
        visor.readAsDataURL(archivoInput.files[0]);
        $('#modalNueve').modal('show');
    }
}

function validarPdfN9() {
    var archivoInput = document.getElementById('novenoArchivo');
    var extPermitidas = /(.pdf)$/i;
    var archivoRuta = archivoInput.value;
    console.log(archivoRuta);

    if (!extPermitidas.exec(archivoRuta)) {
        alert('Ingrese un archivo en formato PDF');
        archivoInput.value = '';
        return;

    }

}


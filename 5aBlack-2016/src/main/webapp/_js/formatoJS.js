function formatar(mascara, documento) {
    var i = documento.value.length;
    var saida = mascara.substring(0, 1);
    var texto = mascara.substring(i)

    if (texto.substring(0, 1) != saida) {
        documento.value += texto.substring(0, 1);
    }

}
function ValidarCPF(Objcpf) {
    var cpf = Objcpf.value;
    var err1 = '111.111.111-11';
    var err2 = '222.222.222-22';
    var err3 = '333.333.333-33';
    var err4 = '444.444.444-44';
    var err5 = '555.555.555-55';
    var err6 = '666.666.666-66';
    var err7 = '777.777.777-77';
    var err8 = '888.888.888-88';
    var err9 = '999.999.999-99';
    exp = /\.|\-/g
    cpf = cpf.toString().replace(exp, "");
    var digitoDigitado = eval(cpf.charAt(9) + cpf.charAt(10));
    var soma1 = 0, soma2 = 0;
    var vlr = 11;

    for (i = 0; i < 9; i++) {
        soma1 += eval(cpf.charAt(i) * (vlr - 1));
        soma2 += eval(cpf.charAt(i) * vlr);
        vlr--;
    }
    soma1 = (((soma1 * 10) % 11) == 10 ? 0 : ((soma1 * 10) % 11));
    soma2 = (((soma2 + (2 * soma1)) * 10) % 11);

    var digitoGerado = (soma1 * 10) + soma2;
    if (digitoGerado != digitoDigitado || err1 === Objcpf.value || err2 === Objcpf.value
            || err3 === Objcpf.value || err4 === Objcpf.value || err5 === Objcpf.value
            || err6 === Objcpf.value || err7 === Objcpf.value || err8 === Objcpf.value || err9 === Objcpf.value)

                $('#campo-cpf').append('<div class="alert alert-danger fade in" id="erro"></div>');
                $('#erro').append('<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>');
                $('#erro').append('<strong>Erro!</strong> CPF Invalido.');
}

/* Este script formata qualquer tipo de campo. DIgite no HTML
 *
 * TELEFONE = <input type="text" name="tel" maxlength="12" OnKeyPress="formatar('##-####-####', this)" >
 * CEP = <input type="text" name="cep" maxlength="9" OnKeyPress="formatar('#####-###', this)" />
 * CPF = <input type="text" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" >
 * */
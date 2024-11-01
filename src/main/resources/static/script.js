console.log("fufunciono")

const url = "http://localhost:8080"

function convertSetorToOption(setor){
    return `<option value="${setor.id}">${setor.nome}</option>`;
}

function convertFuncionarioToTd(funcionario){
    return`
        <tr>
            <th scope="row">${funcionario.id}</th>
            <td>${funcionario.matricula}</td>
            <td>${funcionario.nome}</td>
            <td>${funcionario.setor.nome}</td>
            <td>
                <button type="button" class="btn btn-danger" style="padding:2px 4px 2px 4px">Deletar</button>
                <button type="button" class="btn btn-warning" style="padding:2px 4px 2px 4px">Alterar</button>
            </td>
        </tr>
    `
}

function carregarFuncionarios(){
    const funcionarios = document.getElementById("funcionarios");
    fetch(`${url}/funcionarios`)
    .then((response) => response.json())
    .then((responsejson) => funcionarios.innerHTML += responsejson.map(convertFuncionarioToTd).join(""))
    .catch((error) => console.log(error));
}

function carregarSetores(){
    const setores = document.getElementById("setores");
    fetch(`${url}/setores`)
    .then((response) => response.json())
    .then((responsejson) => setores.innerHTML = responsejson.map(convertSetorToOption).join(""))
    .catch((error) => console.log(error));
}

carregarSetores();
carregarFuncionarios();





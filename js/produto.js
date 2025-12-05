const LINK_API = 'https://fluffy-dollop-q5gjxj5vw6wf9x5j-8080.app.github.dev/';

async function carregarProdutos() {
    const listDiv = document.getElementById('produtos_list');
    const statusDiv = document.getElementById('status_message');
    

    statusDiv.textContent = 'Buscando dados na API...';

    try {

        const resposta = await fetch(`${LINK_API}/produtos`, {
            method: "GET",
            headers: { "Content-Type": "application/json" }
        });

        if (!resposta.ok) {

            throw new Error(`Erro HTTP! Status: ${resposta.status}`);
        }


        const produtos = await resposta.json();

        if (produtos.length === 0) {
            statusDiv.textContent = 'Nenhum produto cadastrado.';
            listDiv.innerHTML = '';
            return;
        }


        statusDiv.textContent = 'Produtos encontrados:';
        

        let tabelaHTML = `
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Disponível</th>
                        <th>Tempo de Preparo</th>
                    </tr>
                </thead>
                <tbody>
        `;

  
        produtos.forEach(produto => {
            tabelaHTML += `
                <tr>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td>R$ ${produto.preco.toFixed(2).replace('.', ',')}</td>
                    <td>${produto.disponivel ? 'Sim' : 'Não'}</td>
                    <td>${produto.tempoDisponivel}</td>
                </tr>
            `;
        });

        tabelaHTML += `
                </tbody>
            </table>
        `;
        
     
        listDiv.innerHTML = tabelaHTML;

    } catch (err) {

        console.error('Erro ao buscar produtos:', err);
        statusDiv.textContent = `❌ Erro ao carregar a lista de produtos. Verifique o console e o CORS da sua API. Detalhe: ${err.message}`;
        listDiv.innerHTML = '';
    }
}
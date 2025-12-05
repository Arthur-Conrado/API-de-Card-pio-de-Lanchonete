const LINK_API = 'https://probable-pancake-7v6rw4jgvv5vcq6x-8080.app.github.dev';

async function cadastrarProduto() {
    const pd_form = document.getElementById('pd_form');
    const pd_resultado = document.getElementById('pd_resultado');

    pd_form.addEventListener("submit", async (e) => {
        e.preventDefault();
        pd_resultado.textContent = 'Enviando dados...'; 

     
        const dados = {
            nome: pd_form.nome.value,
            descricao: pd_form.descricao.value,
           
            preco: parseFloat(pd_form.preco.value),
            
            disponivel: pd_form.disponivel.checked,
           
            tempoDisponivel: pd_form.tempoDisponivel.value, 
        };

        try {
            
            const resposta = await fetch(`${LINK_API}/produtos`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(dados)
            });

            if (resposta.ok) {
           
                const resultado = await resposta.json();
                pd_resultado.textContent = `✅ Produto cadastrado com sucesso! ID: ${resultado.id}`;
                pd_form.reset(); 
            } else {
                
                const erro = await resposta.json();
                pd_resultado.textContent = `❌ Erro ao cadastrar produto. Status: ${resposta.status}. Detalhes: ${JSON.stringify(erro)}`;
            }

        } catch (err) {
           
            console.error('Erro de conexão ou requisição:', err);
            pd_resultado.textContent = `❌ Erro ao enviar dados. Verifique o console do navegador e o status do seu Spring Boot (CORS, API Link).`;
        }
    });
}


cadastrarProduto();
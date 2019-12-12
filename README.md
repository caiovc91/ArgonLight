# ArgonLight
Projeto Argon
Estrutua do projeto:

Aplicativo Argon:

Tela de boas Vindas - FAQ e Quem somos
Tela de consulta:
Menu lateral - navegação
	- controle de empresas, etc
	- navegação in app
	- mapa de consumo
	- gráficos

Gráfico de consumo total (implementação)
Dados de consumo:
	Utilizado
	Somatorio mensal de todas as empresas (valores acordados em contrato)
	
	HOME ->
	Economia acumulada mensal (resumo geral de todas as empresas)
		- Valores destacados
			Economia Acumulada (inicio do contrato)
			CO2 poupado		
		- Medição Mensal (tela geral ultimos 4 meses)
		- Porcentagem de consumo do contrato (??)

	 Gráfico:
		de linha incrementando (valor x mes)
		mostrar apenas os valores, o ultimo valor seria o maior
		possibilidade de visualização a partir do primeiro mês de compensação
		
		Grafico linear ou "rosquinha"
		
		Possibilidade de customização de gráfico de linha, padrão 4 meses
	 
	 Share button (tela de boas vindas)
	 
	 mensagem para contato: telefone 
	 icones de redes sociais
	 
	 Refatoração
		Tela principal:
			Toolbar -> botão 'fale conosco'
					-> botão 'entrar em contato' (icone de pessoa)
					
					
		Possibilidade de exibir offline;
		
		Relatório para consulta:
		Modelo em word
		
		Tela de login:
		possibilidade de salvar login e senha
			hiperlink de bem-vindo
			hiperlink de cadastro / esqueci senha

		Itens de Menu (Lateral):
			Home
			Meus Dados / contratos
			Unidades de consumo
			Faturas
			Notificações (pop "+1")
			"Sobre a Argon" - cnpj, telefone e email e redes sociais

		Tela Home
			 Total acumulado mensal de todas as empresas por filtro
			 Sem gráficos;
			 Valores: economia e CO2
			 Link para tela de empresas especificas
			 
			 
		Tela de Faturas
		Listview com detalhes
			4 boletos por mês
			lista exibe por mês
				Argon, copel, usina, "mais uma"
				Listar por empresa
				apos selecionar abre a lista de meses por empresa
				Dados da lista: categoria do boleto, valor, código copiável, data vencimento
				Sem filtros de categoria de fatura
	
		
		Tela de Unidades de consumo
			dropdown list de empresas
			Gráfico (ultimos 4 meses)
			geração de relatório
			
		
		Meus dados / contratos (Lista com cards que abrem detalhes)
		Nome do cliente
			Resumo das empresas cadastradas | economia assegurada em contrato (anual)
				CNPJ da empresa / logradouro
				Valor assegurado em contrato
				
		
		Tela de Inbox
		Listview com detalhes
			Lista tipo caixa de entrada
				- Resumo da mensagem em json
				clica e abre os detalhes

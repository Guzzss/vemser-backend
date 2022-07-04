-- DECRESCENTE 
SELECT * 
	FROM VEM_SER.PAIS 
	ORDER BY NOME DESC;
	
-- Mostra os logradouros que come�am com A maiusculo 
SELECT LOGRADOURO, CEP 
	FROM VEM_SER.ENDERECO  
	WHERE UPPER(LOGRADOURO) LIKE 'A%';

-- Mosta os ceps que terminam com 0
SELECT *
	FROM VEM_SER.ENDERECO 
	WHERE TRIM(CEP) LIKE '%0';

--Mosta os n�meros que est�o entre 1 e 100
SELECT *
	FROM VEM_SER.ENDERECO e
	WHERE NUMERO BETWEEN 1 AND 100;

-- Mostra os logradouros que come�am com RUA  em ordem DECRESCENTE 
SELECT * 
	FROM VEM_SER.ENDERECO 
	WHERE UPPER(LOGRADOURO) LIKE 'RUA%' 
	ORDER BY CEP DESC;

-- Mostra quandos ID_ENDERECO eu tenho na tabela endere�o 
SELECT COUNT (ID_ENDERECO)
	FROM VEM_SER.ENDERECO;
	
-- Mostra quantos ENDERECOS tem PELO ID DA CIDADE
SELECT COUNT (ID_ENDERECO)
	FROM VEM_SER.ENDERECO 
	GROUP BY ID_CIDADE;
	
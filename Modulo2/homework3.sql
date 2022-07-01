-- RIGHT OUTER JOIN ENTRE TABELA PESSOA E ENDERECO
SELECT P.ID_PESSOA
	  ,P.NOME
	  ,C.ID_PESSOA
	  ,C.DESCRICAO
FROM   
		PESSOA P 
RIGHT OUTER JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA);		

-- RIGHT OUTER JOIN ENTRE TABELA PESSOA, PESSOA_X_PESSOA_ENDERECO E ENDERECO_PESSOA 
SELECT P.ID_PESSOA
	  ,P.NOME
	  ,PXPE.ID_PESSOA
	  ,PXPE.ID_ENDERECO
	  ,EP.ID_ENDERECO
	  ,EP.LOGRADOURO
FROM 
		PESSOA P
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (PXPE.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- RIGHT OUTER JOIN ENTRE TODAS TABELAS
SELECT P.ID_PESSOA
	  ,P.NOME
	  ,C.ID_PESSOA
	  ,C.DESCRICAO
	  ,PXPE.ID_PESSOA
	  ,PXPE.ID_ENDERECO
	  ,EP.ID_ENDERECO
	  ,EP.LOGRADOURO
FROM 
		PESSOA P  
RIGHT OUTER JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (PXPE.ID_PESSOA = P.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- OUTER FULL JOIN ENTRE TABELA PESSOA E CONTATO
SELECT P.ID_PESSOA
	  ,P.NOME
	  ,C.ID_PESSOA
	  ,C.DESCRICAO 
FROM 
		PESSOA P
FULL OUTER JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA);

-- OUTER FULL JOIN ENTRE TABELA PESSOA, PESSOA_X_PESSOA_ENDERECO E ENDERECO_PESSOA
SELECT P.ID_PESSOA 
	  ,P.NOME
	  ,PXPE.ID_PESSOA
	  ,PXPE.ID_ENDERECO
	  ,EP.ID_ENDERECO
	  ,EP.LOGRADOURO
FROM
		PESSOA P
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (PXPE.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- OUTER FULL JOIN ENTRE TODAS AS TABELAS 
SELECT P.ID_PESSOA
	  ,P.NOME
	  ,C.ID_PESSOA
	  ,C.DESCRICAO
	  ,PXPE.ID_PESSOA
	  ,PXPE.ID_ENDERECO
	  ,EP.ID_ENDERECO
	  ,EP.LOGRADOURO
FROM 
		PESSOA P
FULL OUTER JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (PXPE.ID_PESSOA = P.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- SELECIONANDO AS PESSOAS QUE TEM ENDERECO COM O EXISTS 
SELECT P.NOME
FROM PESSOA P 
WHERE EXISTS (SELECT 1
		FROM PESSOA_X_PESSOA_ENDERECO PXPE 
		WHERE P.ID_PESSOA = PXPE.ID_PESSOA);
	
-- SELECIONANDO ID, NOME DA TABELA PESSOA JUNTO COM ID, LOGRADOURO DA TABELA ENDERECO
SELECT p.ID_PESSOA
	  ,P.NOME
FROM PESSOA P
UNION 
SELECT EP.ID_ENDERECO, EP.LOGRADOURO
	FROM ENDERECO_PESSOA EP; 
	
	
	
	
	





		
















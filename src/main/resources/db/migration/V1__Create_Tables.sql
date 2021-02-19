--
-- Estrutura da tabela `atores`
--

CREATE TABLE `atores` (
                          `id` int(11) NOT NULL,
                          `nome` varchar(45) NOT NULL,
                          `filmes_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacoes`
--

CREATE TABLE `avaliacoes` (
                              `id` int(11) NOT NULL,
                              `nota` varchar(45) DEFAULT NULL,
                              `filmes_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Acionadores `avaliacoes`
--
DELIMITER $$
CREATE TRIGGER `calcularMedia` AFTER INSERT ON `avaliacoes` FOR EACH ROW BEGIN
    UPDATE filmes SET totaldeestrelas = totaldeestrelas + NEW.nota, numerodevotos = numerodevotos + 1, media = (totaldeestrelas / numerodevotos) WHERE id = NEW.filmes_id;
END
    $$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `diretor`
--

CREATE TABLE `diretor` (
                           `id` int(11) NOT NULL,
                           `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `filmes`
--

CREATE TABLE `filmes` (
                          `id` int(11) NOT NULL,
                          `nome` varchar(45) NOT NULL,
                          `totaldeestrelas` int(11) NOT NULL,
                          `numerodevotos` int(11) NOT NULL,
                          `genero_id` int(11) NOT NULL,
                          `Diretor_id` int(11) NOT NULL,
                          `media` double(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------



-- --------------------------------------------------------

--
-- Estrutura da tabela `genero`
--

CREATE TABLE `genero` (
                          `id` int(11) NOT NULL,
                          `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `email` varchar(255) NOT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `status` int(11) NOT NULL,
                        `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `email`, `password`,`status`, `username`) VALUES
(1, 'admin@email.com', '$2a$12$eMYaUxO7RpTPQkIXOclIL.xHu7617IIOUtlMAcdj9b2X9nirJRI4q',0, 'admin'),
(2, 'client@email.com', '$2a$12$cHultt3Vl8qpzGBBROJl.OyrGYz6k47m8ha7pQw/JFKL6/mP3MwKK',0, 'client');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_roles`
--

CREATE TABLE `user_roles` (
                              `user_id` int(11) NOT NULL,
                              `roles` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `roles`) VALUES
(1, 0),
(2, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `atores`
--
ALTER TABLE `atores`
    ADD PRIMARY KEY (`id`,`filmes_id`),
  ADD KEY `fk_Atores_filmes_idx` (`filmes_id`);

--
-- Índices para tabela `avaliacoes`
--
ALTER TABLE `avaliacoes`
    ADD PRIMARY KEY (`id`,`filmes_id`),
  ADD KEY `fk_avaliacoes_filmes1_idx` (`filmes_id`);

--
-- Índices para tabela `diretor`
--
ALTER TABLE `diretor`
    ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `filmes`
--
ALTER TABLE `filmes`
    ADD PRIMARY KEY (`id`,`genero_id`,`Diretor_id`),
  ADD KEY `fk_filmes_genero1_idx` (`genero_id`),
  ADD KEY `fk_filmes_Diretor1_idx` (`Diretor_id`);



--
-- Índices para tabela `genero`
--
ALTER TABLE `genero`
    ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- Índices para tabela `user_roles`
--
ALTER TABLE `user_roles`
    ADD KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `atores`
--
ALTER TABLE `atores`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `avaliacoes`
--
ALTER TABLE `avaliacoes`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `diretor`
--
ALTER TABLE `diretor`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `filmes`
--
ALTER TABLE `filmes`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `genero`
--
ALTER TABLE `genero`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `atores`
--
ALTER TABLE `atores`
    ADD CONSTRAINT `fk_Atores_filmes` FOREIGN KEY (`filmes_id`) REFERENCES `filmes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `avaliacoes`
--
ALTER TABLE `avaliacoes`
    ADD CONSTRAINT `fk_avaliacoes_filmes1` FOREIGN KEY (`filmes_id`) REFERENCES `filmes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `filmes`
--
ALTER TABLE `filmes`
    ADD CONSTRAINT `fk_filmes_Diretor1` FOREIGN KEY (`Diretor_id`) REFERENCES `diretor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_filmes_genero1` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `user_roles`
--
ALTER TABLE `user_roles`
    ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;
package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoDoMedico(Long id, String nome, String email, String crm, String telefone,
		Especialidade especialidade, Endereco endereco) {
	public DadosDetalhamentoDoMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
				medico.getEspecialidade(), medico.getEndereco());
	}
}

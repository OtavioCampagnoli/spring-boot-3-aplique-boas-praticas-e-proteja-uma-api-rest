package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoDoPaciente(String nome, String email, String telefone, String cpf, Endereco endereco) {
	public DadosDetalhamentoDoPaciente(Paciente paciente) {
		this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
	}
}

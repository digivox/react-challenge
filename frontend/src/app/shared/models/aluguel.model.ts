import { Cliente } from './cliente.model';
import { Livro } from './livro.model';

export class Aluguel {

	constructor(public dataDeCriacao: string,
				public dataDeDevolucao: string,
				public dataDeRetirada: string,
				public dataPrevistaParaDevolucao: string,
				public status: string,
				public cliente: Cliente,
				public livro: Livro,
				public id?: string) {}

}

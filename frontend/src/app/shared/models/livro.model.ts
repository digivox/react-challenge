export class Livro {

	constructor(public nomeDoAutor: string,
				public codigoISBN: string,
				public cpf: string,
                public titulo: string,
                public subtitulo: string,
                public status: string,
				public id?: string) {}

}
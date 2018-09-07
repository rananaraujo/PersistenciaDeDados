package ufc.qxd.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

public class TesteDeLeitura {
	public static final String ARQUIVO = "/home/carlos/Documentos/cliente.txt";
	public static final String ARQUIVO2 = "/home/carlos/Documentos/livrosdecomedia.txt";
	public static final String ARQUIVO3 = "/home/carlos/Documentos/livrosdeaventura.txt";
	public static final String ARQUIVO4 = "/home/carlos/Documentos/livrosdeDrama.txt";

	public static void main(String[] args) throws Exception {

		ArrayList<Livro> livroList = new ArrayList<Livro>();

		while (true) {
			System.out.println("Bem vindo a livraria do yoda!!");
			System.out.println("O que você deseja fazer?");
			System.out.println("1- adicionar cliente");
			System.out.println("2- excluir cliente");
			System.out.println("3- adicionar livro de Comedia");
			System.out.println("4- adicionar livro de Aventura");
			System.out.println("5- adicionar livro de Drama");
			System.out.println("6- Vender livro de Comedia");
			System.out.println("7- Vender livro de Aventura");
			System.out.println("8- Vender livro de Drama");
			System.out.println("9- Consultar estoque de livros de comedia");
			System.out.println("10- Consultar estoque de livros de aventura");
			System.out.println("11- Consultar estoque de livros de drama");
			System.out.println("0- Sair do progama");
			Scanner ab = new Scanner(System.in);

			int a = ab.nextInt();
			switch (a) {

			case 1:

				OutputStream os = new FileOutputStream(ARQUIVO, true);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);

				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o nome do cliente:");
				String variavel = sc.nextLine();
				bw.write(variavel);
				bw.newLine();
				System.out.println("Digite a data de nascimento do cliente:");
				String teste = sc.nextLine();
				bw.write(teste);
				bw.newLine();
				System.out.println("Digite o endereco do cliente:");
				variavel = sc.nextLine();
				bw.write(variavel);
				bw.newLine();
				System.out.println("Digite o CPF do cliente:");
				String cpf = sc.nextLine();
				bw.write(cpf);
				bw.newLine();

				System.out.println("Cliente adicionado com sucesso!");

				bw.close();

				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			case 2:

				ArrayList<Cliente> cliente = new ArrayList<Cliente>();

				File arquivo = new File(ARQUIVO);
				if (arquivo.exists()) {
					ArrayList<String> clienteList = new ArrayList<String>();
					try {
						BufferedReader in = new BufferedReader(new FileReader(ARQUIVO));
						String dados;
						while (in.ready()) {
							dados = in.readLine();
							clienteList.add(dados);

						}

						for (int i = 0; i < clienteList.size() - 1;) {
							in.close();
							Cliente cliente1 = new Cliente();
							cliente1.setNome(clienteList.get(i));
							i++;
							cliente1.setDantaNascimento(clienteList.get(i));
							i++;
							cliente1.setEndereco(clienteList.get(i));
							i++;
							cliente1.setCpf(clienteList.get(i));
							i++;

							cliente.add(cliente1);

						}

						for (Cliente cliente2 : cliente) {
							System.out.println(
									"nome =" + cliente2.getNome() + " Cpf=" + cliente2.getCpf() + " Data nascimento="
											+ cliente2.getDantaNascimento() + " Endereço=" + cliente2.getEndereco());

						}

						for (int i = 0; i < cliente.size(); i++) {
							Cliente p = cliente.get(i);
							Scanner z = new Scanner(System.in);
							System.out.println("Digite o cpf");
							String b = z.nextLine();

							if (p.getCpf().equals(b)) {

								cliente.remove(p);
								File file = new File(ARQUIVO);
								file.delete();

							}
						}
						for (Cliente cliente2 : cliente) {
							System.out.println(
									"nome =" + cliente2.getNome() + " Cpf=" + cliente2.getCpf() + " Data nascimento="
											+ cliente2.getDantaNascimento() + " Endereço=" + cliente2.getEndereco());
						}

						File file = new File(ARQUIVO);
						OutputStream zu = new FileOutputStream(ARQUIVO);
						OutputStreamWriter w = new OutputStreamWriter(zu);
						BufferedWriter uv = new BufferedWriter(w);

						for (int f = 0; f < cliente.size(); f++) {

							uv.write(cliente.get(f).getNome());
							uv.newLine();
							uv.write(cliente.get(f).getDantaNascimento());
							uv.newLine();
							uv.write(cliente.get(f).getEndereco());
							uv.newLine();
							uv.write(cliente.get(f).getCpf());
							uv.newLine();

						}
						uv.flush();

						uv.close();

					} catch (IOException e) {
						e.printStackTrace();
						throw e;
					}

					System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
					break;
				} else {
					throw new Exception();
				}

			case 3:

				LivroDeComedia iy = new LivroDeComedia();
				System.out.println("Qual o tipo de livro:");
				Scanner bt = new Scanner(System.in);
				String l = bt.nextLine();
				iy.setTipo(l);

				System.out.println("Qual o nome do livro:");
				String o = bt.nextLine();
				iy.setNome(o);

				System.out.println("Qual o ISBN do livro:");
				String y = bt.nextLine();
				iy.setId(y);

				System.out.println("O livro possui capa brochura:");
				String pyh = bt.nextLine();
				iy.setCapaBrochura(pyh);

				System.out.println("Qual a quantidade:");
				int v = bt.nextInt();
				iy.setQtd(v);

				try {
					FileOutputStream t = new FileOutputStream(ARQUIVO2, true);
					ObjectOutputStream oos = new ObjectOutputStream(t);
					oos.writeObject(iy);
					oos.close();
					t.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			case 4:

				LivroDeAventura ipm = new LivroDeAventura();
				System.out.println("Qual o tipo de livro:");
				Scanner qy = new Scanner(System.in);
				String t = qy.nextLine();
				ipm.setTipo(t);
				System.out.println("O livro possui ilustraçoes");
				System.out.println("Qual o nome do livro:");
				String q = qy.nextLine();
				ipm.setNome(q);

				System.out.println("Qual o ISBN do livro:");
				String z = qy.nextLine();
				ipm.setId(z);

				ipm.isIlustracao();

				System.out.println("Qual a quantidade:");
				int qz = qy.nextInt();
				ipm.setQtd(qz);

				try {
					FileOutputStream pi = new FileOutputStream(ARQUIVO3, true);
					ObjectOutputStream oos = new ObjectOutputStream(pi);
					oos.writeObject(ipm);
					oos.close();
					pi.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;
			case 5:

				LivroDeDrama vx = new LivroDeDrama();
				System.out.println("Qual o tipo de livro:");
				Scanner qt = new Scanner(System.in);
				String k = qt.nextLine();
				vx.setTipo(k);

				System.out.println("Qual o nome do livro:");
				String j = qt.nextLine();
				vx.setNome(j);

				System.out.println("Qual o ISBN do livro:");
				String r = qt.nextLine();
				vx.setId(r);

				System.out.println("O livro possui capa dura:");
				String cd = qt.nextLine();
				vx.setCapadura(cd);

				System.out.println("Qual a quantidade:");
				int u = qt.nextInt();
				vx.setQtd(u);

				try {
					FileOutputStream qdc = new FileOutputStream(ARQUIVO4, true);
					ObjectOutputStream oos = new ObjectOutputStream(qdc);
					oos.writeObject(vx);
					oos.close();
					qdc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			case 6:

				File file = new File(ARQUIVO2);
				ArrayList<LivroDeComedia> arrayList = new ArrayList<>();
				if (file.exists()) {
					try {
						FileInputStream in = new FileInputStream(file);
						while (in != null) {

							ObjectInputStream ois = new ObjectInputStream(in);
							arrayList.add((LivroDeComedia) ois.readObject());

						}

					} catch (EOFException e) {

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				System.out.println("Digite o ISBN do livro que deseja vender");

				for (LivroDeComedia livro : arrayList) {

					System.out.println("nome =" + livro.getNome() + " ISBN=" + livro.getId() + " Tipo="
							+ livro.getTipo() + " Quantidade em estoque=" + livro.getQtd() + " Capa brochura="
							+ livro.getCapaBrochura());
				}

				for (int i = 0; i < arrayList.size(); i++) {
					LivroDeComedia p = arrayList.get(i);
					Scanner scanner = new Scanner(System.in);
					String gy = scanner.nextLine();

					if (p.getId().equals(gy)) {
						
							arrayList.remove(p);
							File pq = new File(ARQUIVO2);

							pq.delete();
						
					}
				}
				for (int op = 0; op < arrayList.size(); op++) {
					try {
						File ky = new File(ARQUIVO2);

						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ky, true));
						oos.writeObject(arrayList.get(op));
						oos.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;
			case 7:

				File file2 = new File(ARQUIVO3);
				ArrayList<LivroDeAventura> arrayList2 = new ArrayList<>();
				if (file2.exists()) {
					try {
						FileInputStream in = new FileInputStream(file2);
						while (true) {

							ObjectInputStream ois = new ObjectInputStream(in);
							arrayList2.add((LivroDeAventura) ois.readObject());

						}

					} catch (EOFException e) {

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (LivroDeAventura livro : arrayList2) {

					System.out.println("nome =" + livro.getNome() + " ISBN=" + livro.getId() + " Tipo="
							+ livro.getTipo() + " Quantidade em estoque=" + livro.getQtd() + " possui ilustraçoes="
							+ livro.isIlustracao());
				}
				System.out.println("Digite o ISBN do livro que deseja vender");
				Scanner scanner1 = new Scanner(System.in);
				String pz = scanner1.nextLine();

				for (int i = 0; i < arrayList2.size(); i++) {
					if (arrayList2.get(i).getId().equals(pz)) {
						arrayList2.remove(i);
						File pq = new File(ARQUIVO3);

						pq.delete();
					}
				}

				for (int op = 0; op < arrayList2.size(); op++) {
					try {
						File ky = new File(ARQUIVO3);

						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ky, true));
						oos.writeObject(arrayList2.get(op));
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			case 8:
				File file3 = new File(ARQUIVO4);
				ArrayList<LivroDeDrama> arrayList3 = new ArrayList<>();
				if (file3.exists()) {
					try {
						FileInputStream zx = new FileInputStream(file3);
						while (true) {

							ObjectInputStream ois = new ObjectInputStream(zx);
							arrayList3.add((LivroDeDrama) ois.readObject());

						}

					} catch (EOFException e) {

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (LivroDeDrama livro : arrayList3) {

					System.out
							.println("nome =" + livro.getNome() + " ISBN=" + livro.getId() + " Tipo=" + livro.getTipo()
									+ " Quantidade em estoque=" + livro.getQtd() + " Capa Dura=" + livro.getCapadura());
				}
				System.out.println("Digite o ISBN do livro que deseja excluir");
				Scanner scanner3 = new Scanner(System.in);
				String gpi = scanner3.nextLine();

				for (int i = 0; i < arrayList3.size(); i++) {
					if (arrayList3.get(i).getId().equals(gpi)) {
						arrayList3.remove(i);
						File pq = new File(ARQUIVO4);

						pq.delete();
					}
				}

				for (int op = 0; op < arrayList3.size(); op++) {
					try {
						File ky = new File(ARQUIVO4);

						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ky, true));
						oos.writeObject(arrayList3.get(op));
						oos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			case 9:

				File uhg = new File(ARQUIVO2);
				ArrayList<LivroDeComedia> arrayListvarios = new ArrayList<>();
				if (uhg.exists()) {
					try {
						FileInputStream in = new FileInputStream(uhg);
						while (true) {

							ObjectInputStream ois = new ObjectInputStream(in);
							arrayListvarios.add((LivroDeComedia) ois.readObject());

						}

					} catch (EOFException e) {

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				for (LivroDeComedia livro : arrayListvarios) {

					System.out.println("nome =" + livro.getNome() + " ISBN=" + livro.getId() + " Tipo="
							+ livro.getTipo() + " Quantidade em estoque=" + livro.getQtd() + " Capa Brochura="
							+ livro.getCapaBrochura());
				}
				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			case 10:
				File uh = new File(ARQUIVO3);
				ArrayList<LivroDeAventura> arrayListvarios1 = new ArrayList<>();
				if (uh.exists()) {
					try {
						FileInputStream in = new FileInputStream(uh);
						while (true) {

							ObjectInputStream ois = new ObjectInputStream(in);
							arrayListvarios1.add((LivroDeAventura) ois.readObject());

						}

					} catch (EOFException e) {

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				for (LivroDeAventura livro : arrayListvarios1) {

					System.out.println("nome =" + livro.getNome() + " ISBN=" + livro.getId() + " Tipo="
							+ livro.getTipo() + " Quantidade em estoque=" + livro.getQtd() + " Ilustração="
							+ livro.isIlustracao());
				}
				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;
			case 11:
				File ubc = new File(ARQUIVO4);
				ArrayList<LivroDeDrama> arrayListvarios2 = new ArrayList<>();
				if (ubc.exists()) {
					try {
						FileInputStream in = new FileInputStream(ubc);
						while (true) {

							ObjectInputStream ois = new ObjectInputStream(in);
							arrayListvarios2.add((LivroDeDrama) ois.readObject());

						}

					} catch (EOFException e) {

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				for (LivroDeDrama livro : arrayListvarios2) {

					System.out
							.println("nome =" + livro.getNome() + " ISBN=" + livro.getId() + " Tipo=" + livro.getTipo()
									+ " Quantidade em estoque=" + livro.getQtd() + " Tipo=" + livro.getTipo());
				}
				System.out.println("Digite 1 para retornar para o menu ou 0 para encerrar o progama");
				break;

			}

			if (ab.nextInt() == 0) {
				break;
			}

			System.out.println("Progama Finalizado");

		}

	}
}
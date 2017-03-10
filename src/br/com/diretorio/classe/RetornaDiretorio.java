package br.com.diretorio.classe;

import java.io.IOException;

import javax.swing.GroupLayout.SequentialGroup;

public class RetornaDiretorio {
	private String recebeDiretorio = "";
	private String diretorio;
	private String mantemDiretorio;
	private String ftp = "";

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
	
	public void setMantemDiretorio(String diretorio){
		this.mantemDiretorio = diretorio;
	}
	
	public String getDiretorio() {
		return this.diretorio;
	}

	public String getFtp() {
		return this.ftp;
	}

	public String retiraTrecho() {
		// Retira o trecho D:\FTP\ do diretorio;
		for (int i = 0; i < this.diretorio.length(); i++) {
			if (i > 6) {
				this.recebeDiretorio += this.diretorio.charAt(i);
			}
		}
		return this.recebeDiretorio;
	}

	public void converteDiretorioParaFTP() {
		setMantemDiretorio(this.diretorio);
		this.diretorio = retiraTrecho();

		int entradaAsc = 92;
		int saidaAsc = 47;

		char entradaChar = (char) entradaAsc;
		char saidaChar = (char) saidaAsc;

		// Altera a barra(\) para a barra(/)
		this.diretorio = this.diretorio.replace(entradaChar, saidaChar);

		/*
		 * try { Runtime.getRuntime().exec("explorer " + mantemDiretorio);
		 * Runtime.getRuntime().exec("explorer " + ftp); } catch (IOException e)
		 * {  e.printStackTrace(); }
		 */
	}

	public void irParaDiretorios(boolean irD, boolean irFtp, String ftp) {
		if (irD && irFtp) {
			try {
				Runtime.getRuntime().exec("explorer " + this.mantemDiretorio);
				Runtime.getRuntime().exec("explorer " + ftp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (irD && !irFtp) {
			try {
				Runtime.getRuntime().exec("explorer " + this.mantemDiretorio);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} else if (!irD && irFtp) {
			try {
				Runtime.getRuntime().exec("explorer " + ftp);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public void verificaStringVazia(boolean irD, boolean irFtp) {
		if (!(diretorio.trim().isEmpty())) {
			this.ftp = "FTP://200.155.3.179/" + this.diretorio;
			irParaDiretorios(irD, irFtp, this.ftp);
		}
	}
}

package br.com.rsinet.hub_TDD.projeto.utilitys;

public class ExcelData {

	public static String nome = ExcelUtils.getCellData(1, 0);
	public static String email = ExcelUtils.getCellData(1, 2);
	public static String senha = ExcelUtils.getCellData(1, 8);
	public static String ultimoNome = ExcelUtils.getCellData(1, 1);
	public static String telefone = ExcelUtils.getCellData(1, 3);
	public static String pais = ExcelUtils.getCellData(1, 9);
	public static String cidade = ExcelUtils.getCellData(1, 4);
	public static String endereco = ExcelUtils.getCellData(1, 5);
	public static String estado = ExcelUtils.getCellData(1, 6);
	public static String cep = ExcelUtils.getCellData(1, 7);

}

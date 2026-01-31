public class ProcessadorDeRelatorios {

    private static final ThreadLocal<Integer> userIdLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> preferenciaLocal = new ThreadLocal<>();

    public static void configurarUsuario(int userId, String preferencia) {
        userIdLocal.set(userId);
        preferenciaLocal.set(preferencia);
    }

    public static void limparConfiguracao() {
        userIdLocal.remove();
        preferenciaLocal.remove();
    }

    public Relatorio processarRelatorio() {
        Integer userId = userIdLocal.get();
        String preferencia = preferenciaLocal.get();

        if (userId == null) {
            throw new IllegalStateException("UserID não configurado para o thread atual.");
        }

        if (preferencia == null) {
            preferencia = "Relatório genérico";
        }

        long ts = System.currentTimeMillis();
        String conteudo = "Conteúdo do relatório das " + preferencia;

        return new Relatorio(userId, ts, conteudo);
    }
}

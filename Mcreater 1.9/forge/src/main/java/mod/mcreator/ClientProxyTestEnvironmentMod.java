

public class ClientProxyTestEnvironmentMod extends CommonProxyTestEnvironmentMod {

	@Override
	public void registerRenderers(TestEnvironmentMod ins) {
		ins.mcreator_0.registerRenderers();
		ins.mcreator_1.registerRenderers();

	}
}

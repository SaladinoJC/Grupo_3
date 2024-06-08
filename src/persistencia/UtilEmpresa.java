package persistencia;

import empresa.Empresa;

public class UtilEmpresa {

	public static EmpresaDTO empresaDTOfromEmpresa(Empresa empresa, int cantClientes, int cantMaximaViajesPorCliente, int cantChoferesDeCadaTipo, int cantMaximaViajesPorChofer, int cantMaximaVehiculosDeCadaTipo){
		EmpresaDTO res = new EmpresaDTO();
		res.setCantClientes(cantClientes);
		res.setCantMaximaViajesPorCliente(cantMaximaViajesPorCliente);
		res.setCantChoferesDeCadaTipo(cantChoferesDeCadaTipo);
		res.setCantMaximaViajesPorChofer(cantMaximaViajesPorChofer);
		res.setCantMaximaVehiculosDeCadaTipo(cantMaximaVehiculosDeCadaTipo);
		res.setChoferes(empresa.getChoferes());
		res.setClientes(empresa.getClientes());
		res.setVehiculos(empresa.getVehiculos());
		res.setViajes(empresa.getViajes());
		return res;
    }

    public static void empresaFromEmpresaDTO(EmpresaDTO eDTO, Empresa empresa){
    	empresa.setChoferes(eDTO.getChoferes());
    	empresa.setClientes(eDTO.getClientes());
    	empresa.setVehiculos(eDTO.getVehiculos());
    	empresa.setViajes(eDTO.getViajes());
    }
    
    public static ParametrosIniciales obtenerParametrosIniciales(EmpresaDTO eDTO) {
    	ParametrosIniciales pi= new ParametrosIniciales();
    	
    	pi.setCantChoferesDeCadaTipo(eDTO.getCantChoferesDeCadaTipo());
    	pi.setCantClientes(eDTO.getCantClientes());
    	pi.setCantMaximaVehiculosDeCadaTipo(eDTO.getCantMaximaVehiculosDeCadaTipo());
    	pi.setCantMaximaViajesPorChofer(eDTO.getCantMaximaViajesPorChofer());
    	pi.setCantMaximaViajesPorCliente(eDTO.getCantMaximaViajesPorCliente());
    	return pi;
    }

}

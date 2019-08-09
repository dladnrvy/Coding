package member;

public class Assembler {

	//보관 객체
	private MemberDao memberDao;
	private MemberRegisetService regisetService;
	private ChangePasswordService pwService;
	
	public Assembler() {
	//객체 생성, 주입
		memberDao = new MemberDao();
		/*
		 * regisetService = new MemberRegisetService(memberDao); pwService = new
		 * ChangePasswordService(memberDao);
		 */
		
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisetService getRegisetService() {
		return regisetService;
	}

	public ChangePasswordService getPwService() {
		return pwService;
	}
	
}

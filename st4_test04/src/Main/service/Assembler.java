package Main.service;

import Main.DTO.MemberDAO;
		// 객체 조립기
public class Assembler {
	private MemberDAO memberDao;
	private MemberPrinter printer;
	private MemberRegisterService memberRegisterService;
	private MemberListPrinter memberListPrinter;
	private ChangePasswordService changePasswordService;
	private MemberInfoPrinter memberInfoPrinter;
	public Assembler() {
		this.memberDao = new MemberDAO();
		this.printer = new MemberPrinter();
		this.memberRegisterService = new MemberRegisterService(memberDao);
		this.memberListPrinter = new MemberListPrinter(memberDao, printer);
		this.changePasswordService = new ChangePasswordService();
		this.memberInfoPrinter = new MemberInfoPrinter();
	}
	public MemberInfoPrinter getMemberInfoPrinter() {
		memberInfoPrinter.setMemberDAO(memberDao);
		memberInfoPrinter.setPrinter(printer);
		return memberInfoPrinter;
	}
	public ChangePasswordService getChangePasswordService() {
		changePasswordService.setMemberDao(memberDao);
		return changePasswordService;
	}
	public MemberPrinter getPrinter() {
		return printer;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public MemberListPrinter getMemberListPrinter() {
		return memberListPrinter;
	}
	public MemberDAO getMemberDao() {
		return memberDao;
	}
	
	
}

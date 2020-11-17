<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.clinic.pet.util.DBManager_vet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*" import="java.util.*"
	import="javax.xml.parsers.DocumentBuilder"
	import="javax.xml.parsers.DocumentBuilderFactory"
	import="javax.xml.parsers.ParserConfigurationException"
	import="org.w3c.dom.Document" import="org.w3c.dom.NamedNodeMap"
	import="org.w3c.dom.NodeList" import="org.xml.sax.SAXException"
	import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>병원리스트</h1>
	<table>
		<tr>
			<th>서비스명</th>
			<th>승인날짜</th>
			<th>영업</th>
			<th>전화번호</th>
			<th>지번주소</th>
			<th>도로명주소</th>
			<th>우편번호</th>
			<th>업체명</th>
		</tr>

	</table>
	<%
		String url = "http://localhost:8181/PetClinic/project_hp/AnimalHospitalList.xml";

		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = docBuilder.parse(url);

		NodeList tag_opnSvcNm = doc.getElementsByTagName("opnSvcNm");
		NodeList tag_apvPermYmd = doc.getElementsByTagName("apvPermYmd");
		NodeList tag_dtlStateNm = doc.getElementsByTagName("dtlStateNm");
		NodeList tag_siteTel = doc.getElementsByTagName("siteTel");
		NodeList tag_siteWhlAddr = doc.getElementsByTagName("siteWhlAddr");
		NodeList tag_rdnWhlAddr = doc.getElementsByTagName("rdnWhlAddr");
		NodeList tag_rdnPostNo = doc.getElementsByTagName("rdnPostNo");
		NodeList tag_bplcNm = doc.getElementsByTagName("bplcNm");

		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBManager_vet.getConnection();
		for (int i = 0; i < tag_opnSvcNm.getLength(); i++) {

			String L1 = tag_opnSvcNm.item(i).getTextContent();
			String L2 = tag_apvPermYmd.item(i).getTextContent();
			String L3 = tag_dtlStateNm.item(i).getTextContent();
			String L4 = tag_siteTel.item(i).getTextContent();
			String L5 = tag_siteWhlAddr.item(i).getTextContent();
			String L6 = tag_rdnWhlAddr.item(i).getTextContent();
			String L7 = tag_rdnPostNo.item(i).getTextContent();
			String L8 = tag_bplcNm.item(i).getTextContent();

			if (L4 == null || L4 == "" || L4.equals("0")) {
				L4 = "전화번호 없음";
			}
			/*브라우저창에 리스트 띄우기*/
			ArrayList<String> AHL = new ArrayList<String>();
			AHL.add(L1 + " - " + L2 + " - " + L3 + " - " + L4 + " - " + L5 + " - " + L6 + " - " + L7 + " - " + L8);

			out.println(AHL);

			/*DB에 내용 넣기*/
			String sql = "insert into AHL values(AHL_seq.nextval, ?,?,?,?,?,?,?,?)";

			try {

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, L1);
				out.println(1);
				pstmt.setString(2, L2);
				out.println(2);
				pstmt.setString(3, L3);
				out.println(3);
				pstmt.setString(4, L4);
				out.println(4);
				pstmt.setString(5, L5);
				out.println(5);
				pstmt.setString(6, L6);
				out.println(6);
				pstmt.setString(7, L7);
				out.println(7);
				pstmt.setString(8, L8);
				out.println(8);

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager_vet.close(pstmt);
			}
		}
		out.println("완료됨");
	%>

<body>





</body>
</html>
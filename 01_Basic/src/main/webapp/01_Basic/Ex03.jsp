<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! public int add(int a, int b){
		int addResult = a + b;
		return addResult;
	}

	public int subtract(int a, int b){
		int subResult = a - b;
		return subResult;
	}
%>
	
<%
int su1 = 3;
int su2 = 10;

int addResult = add(su1,su2);
int subResult = subtract(su1,su2);
%>
결과1 : <%=su1 %> + <%=su2 %> = <%=addResult %>
 	<br>
결과2 : <%=su1 %> - <%=su2 %> = <%=subResult %>

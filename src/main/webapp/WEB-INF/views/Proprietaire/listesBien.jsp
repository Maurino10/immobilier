<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.bien.Immobilier.Model.Bien"%>
<%
    List<Bien> biens = (List<Bien>) request.getAttribute("listeBien");
    out.print(biens.get(0).getNom());
%>
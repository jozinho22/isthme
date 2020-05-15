package com.douineau.utils;

public class TagBuilder {
	
//	public static String buildTag() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("<th scope=\"col\">");
//		sb.append("<button type=\"submit\">Commandes</button>");
//		sb.append("</th>");
//		
//		return sb.toString();
//	}
	
	public static String buildGererLesPosts(String avisRestants) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<li class=\"nav-item\">");
		sb.append("<a class=\"nav-link\" href=\"gestion-avis\">Gérer les posts (");
                sb.append(avisRestants);
                sb.append(")</a>");	
		sb.append("</li>"); 
		
		return sb.toString();
	}
	
	public static String buildPrev() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<button onclick=\"passNbPrev(this);\" type=\"submit\" id=\"carousel-inner-1\" class=\"carousel-control-prev\" role=\"button\">");
		sb.append("<i class=\"fa fa-angle-left text-dark text-lg\"></i>");
		sb.append("<span\" class=\"sr-only\">Previous </span>");
		sb.append("</button>");
		
		return sb.toString();
	}
	
	public static String buildNext() {
		StringBuilder sb = new StringBuilder();
		sb.append("<button onclick=\"passNbNext(this);\" type=\"submit\" class=\"carousel-control-next\" role=\"button\">");
		sb.append("<i class=\"fa fa-angle-right text-dark text-lg\"></i>");
		sb.append("<span\" class=\"sr-only\">Next </span>");
		sb.append("</button>");
		
		return sb.toString();
	}
	
	public static String buildCarouselItem(int k) {
		StringBuilder sb = new StringBuilder();
		if(k == 0) 
			sb.append("<div class=\"carousel-item active\">");
		else 
			sb.append("<div class=\"carousel-item\">");
		
		return sb.toString();
	}
	
	public static String closeCarouselItem() {
		StringBuilder sb = new StringBuilder();
		sb.append("</div>");
		
		return sb.toString();
	}
}

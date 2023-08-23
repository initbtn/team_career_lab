<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Main <sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
            	<c:choose>
            		<c:when test="${empty userId}">
            			<a class="nav-link" href="/">
	                    <i class="fas fa-fw fa-tachometer-alt"></i>
	                    	<span>Home</span></a>
            		</c:when>
            	</c:choose>
            	<c:choose>
            		<c:when test="${empty userId}">
                    </c:when>
	                    <c:otherwise>
			                <a class="nav-link" href="/career/get">
			                    <i class="fas fa-fw fa-tachometer-alt"></i>
			                    <span>My Career</span></a>
	                    </c:otherwise>
            	</c:choose>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>게시글</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Components:</h6>
                        <a class="collapse-item" href="/board/list">게시글</a>
                        <a class="collapse-item" href="/board/register">등록</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item active">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>채용공고</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                	<c:choose>
                		<c:when test="${empty userId }">
		                    <div class="bg-white py-2 collapse-inner rounded">
		                        <a class="collapse-item" type="button" href="#" data-toggle="modal" data-target="#loginmodal">
		                		</a>
		                    </div>
                		</c:when>
                		<c:otherwise>
                			 <div class="bg-white py-2 collapse-inner rounded">
		                        <a class="collapse-item" href="/company/listJob" >
		                		</a>
		                    </div>
                		</c:otherwise>
                	</c:choose>
                </div>
            </li>


        </ul>
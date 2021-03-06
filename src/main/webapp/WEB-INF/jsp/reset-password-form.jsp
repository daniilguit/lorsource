<%@ page contentType="text/html; charset=utf-8"%>
<%@ page buffer="64kb"%>
<%--
  ~ Copyright 1998-2012 Linux.org.ru
  ~    Licensed under the Apache License, Version 2.0 (the "License");
  ~    you may not use this file except in compliance with the License.
  ~    You may obtain a copy of the License at
  ~
  ~        http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~    Unless required by applicable law or agreed to in writing, software
  ~    distributed under the License is distributed on an "AS IS" BASIS,
  ~    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~    See the License for the specific language governing permissions and
  ~    limitations under the License.
  --%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="lor" %>

<jsp:include page="/WEB-INF/jsp/head.jsp"/>

<title>Сбросить пароль</title>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<H1>Получить забытый пароль</H1>
<form method=POST action="/reset-password">
  <lor:csrf/>
  <label>Логин: <input type=text name=nick size=40><br></label>
  <label>Код: <input type=text name=code size=40><br></label>
<input type=submit value="Сбросить">
</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

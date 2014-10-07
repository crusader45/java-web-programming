java-web-programming
====================

자바에서 자바 기반 웹 프로그래밍을 다룬다.


1단계

  - web.xml에 ServletContextLoader라는 클래스를 ServletContexteListener로 설정되어 있다.
  - QnaContextLoaderListener라는 클래스도 listener로 설정 되어 있다.
  - 각각의 listener들은 ServletContext가 생성된 이후에,contextInitialized()를 실행하게 된다.
  - QnaContextLoaderListener는 database 설정 관련하여 초기화 작업을 진행한다.
  - ServletContextLoader는 RequestMapping이라는 객체를 생성하고, initMapping()를 실행한다.
  - initMapping()에서 map에 url을 key, 해당 url을 요청받을 때, 처리해야할 controller를 생성하여 map에 담는다.
  - servletContext에 key값이 "DEFAULT_REQUEST_MAPPING"으로 하여RequestMapping 객체를 담는다.
  - FrontController는 web.xml에 *.next로 맵핑된 Controller이며며, 여기서 모든 요청을 받는다.
  - service()를 상속받아 실행하고, 해당 url로 map에서 꺼낸 controller를 실행하여 요청을 처리한다.




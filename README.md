# Produce300 Node.js -> Spring Boot 전환
 

## 1.환경구성
- Spring Boot 2.3.1.RELEASE
- Java : 14
- Gradle
- lombok
- Mongo DB
- Docker 배포

## 2. Docker
- Spring Boot
    * jar 파일 생성 후 Dockerfile을 통해 이미지 빌드 및 배포
    * 다른 컨테이너에 있는 몽고DB와 통신하기 위해 몽고DB와 동일한 network에 연결
    > docker network create [네트워크명]    
    
    > docker network connect [네트워크명] [컨테이너명]

    * 참조 : [https://docs.docker.com/network/bridge/](https://docs.docker.com/network/bridge/)
    * mongo DB의 host 값 변경 : localhost -> mongo
    
- Mongo DB
    * `kge` DB를 생성하고 특정 아이디에 읽기 권한 부여. 스프링부트 프로젝트에서 read만 하고 있기 때문에 읽기 권한 있는 아이디로 접속 하도록 설정
    * DB 데이터는 로컬에 저장되도록 로컬 디렉토리를 마운트

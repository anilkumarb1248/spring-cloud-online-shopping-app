#---With Layer approach
FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 2031
ENTRYPOINT ["java","-cp","app:app/lib/*","com.online.shopping.search.SearchServiceApplication"]
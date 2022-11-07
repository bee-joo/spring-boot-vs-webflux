for d in ./spring*/
do
  (cd "$d" && ./gradlew clean && ./gradlew build)
done

docker-compose up -d
# --- Stage 1: Build the application ---
# Χρησιμοποιούμε μια εικόνα που έχει Maven και Java 17 (άλλαξε το σε 21 αν επέλεξες Java 21)
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Αντιγράφουμε το pom.xml και τον κώδικα
COPY pom.xml .
COPY src ./src

# Χτίζουμε το project (προσπερνώντας τα tests για ταχύτητα σε αυτό το στάδιο)
RUN mvn clean package -DskipTests

# --- Stage 2: Run the application ---
# Χρησιμοποιούμε μια πολύ ελαφριά εικόνα μόνο με το JRE για να τρέξουμε το app
FROM eclipse-temurin:21-jre
WORKDIR /app

# Παίρνουμε το .jar που φτιάχτηκε στο προηγούμενο στάδιο (build)
COPY --from=build /app/target/*.jar app.jar

# Η εντολή που τρέχει όταν ξεκινάει το container
ENTRYPOINT ["java", "-jar", "app.jar"]
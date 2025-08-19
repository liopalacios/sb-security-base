pipeline {
    agent any

    tools {
        gradle 'Gradle' // Configura Gradle en Jenkins (Manage Jenkins > Global Tool Configuration)
    }

    environment {
        SONARQUBE_ENV = 'sonarqube'
    }

    stages {
        stage('Init') {
            steps {
                echo '✅ Pipeline iniciado correctamente'
            }
        }
    }
}

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo "Compilando en la rama ${env.GIT_BRANCH}"
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Deploy') {
            when {
                expression { env.GIT_BRANCH == "origin/main" }
            }
            steps {
                echo "🚀 Haciendo deploy en MAIN"
                // tus pasos de deploy
            }
        }
    }
}
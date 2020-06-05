pipeline{
    agent any

    stages{
        stage("Preparation"){
            steps{
            echo "Download updates"
            git "https://github.com/Olha2805/Artefacts.git"
            }
           }

           stage("Unit_Test"){
            steps{
                bat 'mvn clean -DsuiteXmlFile=unit-testng.xml test'
            }
           }

           stage("Ui_Test"){
            steps{
             bat 'mvn clean -DsuiteXmlFile=unit-testng.xml test'
            }
           }
    }
}
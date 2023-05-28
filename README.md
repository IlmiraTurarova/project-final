## [REST API](http://localhost:8080/doc)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```

<h2>List of completed tasks:</h2>

<p>&#10004;&#65039; 1. Understand the project structure (onboarding).</p>
<p>&#10004;&#65039; 2. Remove social networks: vk, yandex.</p>
<img src="resources/images/2_1.jpg"/>
<div align="center"><b>Before</b></div>
<br>
<img src="resources/images/2_2.jpg"/>
<div align="center"><b>After</b></div>
<br>
<p>&#10004;&#65039; 3. Transfer sensitive information (login, database password, identifiers for OAuth registration/authorization, mail settings) to a separate property file. The values of these properties must be read at server startup from the environment variables of the machine.</p>
<img src="resources/images/3_1.jpg"/>
<br>
<img src="resources/images/3_2.jpg"/>
<br>
<p>&#10004;&#65039; 4. Correct the tests so that during the tests the in memory database (H2) is used, and not PostgreSQL. To do this, you need to define 2 beans, and the selection of which one to use should be determined by the active Spring profile.</p>
<img src="resources/images/4_1.jpg"/>
<br>
<img src="resources/images/4_2.jpg"/>
<br>
<p>&#10004;&#65039; 5. Write tests for all public methods of the ProfileRestController controller.</p>
<img src="resources/images/5_1.jpg"/>
<br>
<p>&#10004;&#65039; 6. Add new functionality: adding tags to the task. The front is optional. (Without front)</p>
<img src="resources/images/6_1.jpg"/>
<br>
<p>&#10004;&#65039; 9. Write a Dockerfile for the main server.</p>
<p>&#10004;&#65039; 10. Write a docker-compose file to run the server container along with the database and nginx. For nginx, use the config/nginx.conf config file. If necessary, the config file can be edited.</p>
<p>&#10004;&#65039; In config/_application-prod.yaml correct <br>
<i>url: jdbc:postgresql://db:5432/jira</i></p>
<img src="resources/images/9_1.jpg"/>
<br>
<img src="resources/images/9_2.jpg"/>
<br>
<p>&#10004;&#65039; 11. Add localization in at least two languages for letter templates (mails) and index.html start page.</p>
<img src="resources/images/11_1.jpg"/>
<div align="center"><b>Before</b></div>
<br>
<img src="resources/images/11_2.jpg"/>
<div align="center"><b>After</b></div>
<br>
<img src="resources/images/11_3.jpg"/>
<div align="center"><b>After</b></div>
<br>
<img src="resources/images/11_4.jpg"/>
<div align="center"><b>After</b></div>


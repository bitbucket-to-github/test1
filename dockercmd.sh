docker info                 
docker build -t fineshift_emp .  # Build docker image frm dockerfile
docker run -itd -p 8080:8080  --name fineshift_emp_info fineshift_emp   #create container using docker image 
docker ps 
docker inspect fineshift_emp_info  # getting info about container     

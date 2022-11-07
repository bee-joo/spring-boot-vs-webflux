FROM python:3.10-alpine

WORKDIR /project

COPY . /project

RUN pip install -r /project/requirements.txt

EXPOSE 8083

CMD ["python", "/project/main.py"]
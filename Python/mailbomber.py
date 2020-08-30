import smtplib
import imghdr
from email.message import EmailMessage

msg=EmailMessage()
print("""We do not collect any data!!!\n
Sender first need to  follow the link https://myaccount.google.com/u/1/lesssecureapps and enable Less Secure app
""")
try:
    msg["From"]=input("Sender's gmail_account : ")
    gmail_password=input("Sender's password : ")
    msg["To"]=input("\nReceiver's address\nIf multiple receivers are there then write comma seperated emails\nFor e.g. 'user1@gmail.com,user2@gmail.com')  : \n")
    msg["Subject"]=input("Enter Subject : ")
    txt_or_html=input('What do you want to add text or html alternative ?(txt or html) : ')

    #Attach HTML file alternative
    if txt_or_html=="html":
        html_content=input("Enter HTML code : ")
        msg.add_alternative(html_content,subtype="html")
    elif txt_or_html=="txt":
        email_content=input("Enter text : ")
        msg.set_content(email_content)

    else:
        msg.set_content("")

    #Attach Images

    attach_photo=input('Do you want to attach images?(y/n or yes/no) : ').lower()[0]
    if attach_photo=="y":
        images_location=input("Enter image locations (comma-seperated locations for multiple locations )\nFor e.g. image1.jpg,image2.jpg : ")
        images_list=images_location.split(",")
        for i in images_list:
            with open(i,"rb") as f:
                image_file=f.read()
                image_type=imghdr.what(f.name)
                image_name=f.name
            msg.add_attachment(image_file,maintype='image',subtype=image_type,filename=image_name)


    #Attach PDFs

    attach_pdf=input('Do you want to attach pdfs?(y/n or yes/no) : ').lower()[0]
    if attach_pdf=="y":
        pdfs_location=input("Enter pdf locations (comma-seperated locations for multiple locations )\nFor e.g. pdf1.pdf,pdf2.pdf : ")
        pdfs_list=pdfs_location.split(",")
        for i in pdfs_list:
            with open(i,"rb") as f:
                pdf_file=f.read()
                pdf_name=f.name
            msg.add_attachment(pdf_file,maintype='application',subtype="octet-stream",filename=pdf_name)
    #No. of mails

    num_of_times=int(input("Enter number of mails you want to send ? : "))
    for i in range(num_of_times):
        with smtplib.SMTP_SSL('smtp.gmail.com',465) as smtp:
            smtp.login(msg['From'],gmail_password)
            smtp.send_message(msg)
            print("Email sent successfully!!!")
except Exception as e:
    print(e)

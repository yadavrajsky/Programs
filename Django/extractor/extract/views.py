# from django.shortcuts import render
# from django.http import HttpResponse
# from .forms import UploadFileForm
# from .file_handler import handle_uplaoded_file


# def upload(request):
# 	if(request.method=='POST'):
# 		form=UplaodFileForm(request.POST,request.FILES)
# 		if form.is_valid():
# 			content=handle_uplaoded_file(request.FILES['file'])
# 			return render('extract/output.html',{'content':content})
# 	else:
# 		form =UploadFileForm()
# 	return render(request,'extract/fileupload.html',{'forms':form})

from django.http import HttpResponseRedirect
from django.shortcuts import render
from .forms import UploadFileForm

# Imaginary function to handle an uploaded file.
from .file_handler import *


def upload(request):
    if request.method == 'POST':
        print(request.POST)
        request_for = request.POST['selection']
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = handle_uploaded_file(request.FILES['file'], request_for)
            # requested_for=request.FILES['selection']
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/fileupload.html', {'form': form})


def custom_email(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)

        if form.is_valid():
            output = custom_emails_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
        return render(request, "extract/email_custom.html", {'form': form})


def email(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = all_emails_handlers(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/email.html', {'form': form})


# Phone

def phone(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = all_phone_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/phone_number.html', {'form': form})


def custom_phone(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)

        if form.is_valid():
            output = custom_phone_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
        return render(request, "extract/email_custom.html", {'form': form})


# Date

def dates(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = all_dates_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/urls.html', {'form': form})


# Alphanumeric

def alphanumeric(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = all_alphanumeric_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/urls.html', {'form': form})

# Urls



def urls(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = all_urls_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/urls.html', {'form': form})


def custom_urls(request):
    if request.method == 'POST':
        form = UploadFileForm(request.POST, request.FILES)

        if form.is_valid():
            output = custom_urls_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
        return render(request, "extract/custom_urls.html", {'form': form})


def custom(request):
    if request.method == "POST":
        form = UploadFileForm(request.POST, request.FILES)
        if form.is_valid():
            output = custom_handler(request.FILES['file'], request.POST)
            return render(request, 'extract/output.html', {'output': output})
    else:
        form = UploadFileForm()
    return render(request, 'extract/custom.html', {'form': form})

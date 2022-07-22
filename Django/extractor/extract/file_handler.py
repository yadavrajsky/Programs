import re


# Email Handler


def all_emails_handlers(file, requests):
    matches = []
    file_content = file.readlines()
    pattern = re.compile(rf"[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+")
    for line in file_content:
        matches += pattern.findall(line.decode())
    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")
    return matches


def custom_emails_handler(file, requests):
    matches = []
    content = file.readlines()
    for i, j in requests.items():
        print(i, j)

    if (requests['EmailUsername']):
        letters = requests['EmailUsername']
        file_content = content
        if (('EmailStartingWithUsername' not in requests) and ('EmailEndingWithUsername' not in requests)):
            if ('EmailUsernameCase' in requests):
                pattern = re.compile(
                    rf'\b[a-zA-Z_.0-9%+-]*{letters}[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
            else:
                pattern = re.compile(
                    rf'\b[a-zA-Z_.0-9%+-]*{letters}[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*')
            for line in file_content:
                matches += pattern.findall(line.decode())
        else:

            if ('EmailStartingWithUsername' in requests):
                if ('EmailUsernameCase' in requests):
                    pattern = re.compile(
                        rf'\b{letters}+[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
                else:
                    pattern = re.compile(
                        rf'\b{letters}+[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*')
                for line in file_content:
                    matches += pattern.findall(line.decode())

            if ('EmailEndingWithUsername' in requests):
                if ('EmailUsernameCase' in requests):
                    pattern = re.compile(
                        rf'\b[a-zA-Z0-9_.]*{letters}@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
                else:
                    pattern = re.compile(
                        rf'\b[a-zA-Z0-9_.]*{letters}@[a-zA-Z]*\.[a-zA-Z]*')
                for line in file_content:
                    matches += pattern.findall(line.decode())

    if (requests['EmailDomain']):
        letters = requests['EmailDomain']
        file_content = content
        if ('EmailDomainCase' in requests):
            pattern = re.compile(
                rf'[a-zA-Z0-9_.]*@{letters}\.[a-zA-Z]*', re.IGNORECASE)
        else:
            pattern = re.compile(rf'[a-zA-Z0-9_.]*@{letters}\.[a-zA-Z]*')
        for line in file_content:
            matches += pattern.findall(line.decode())

    if (requests['EmailDotSomething']):
        letters = requests['EmailDotSomething']
        file_content = content
        if ('EmailDotSomethingCase' in requests):
            pattern = re.compile(
                rf'[a-zA-Z0-9_.]*@[a-zA-Z]*\.{letters}', re.IGNORECASE)
        else:
            pattern = re.compile(rf'[a-zA-Z0-9_.]*@[a-zA-Z]*\.{letters}')
        for line in file_content:
            matches += pattern.findall(line.decode())

    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")
    return matches
# Aplhanumeric

def all_alphanumeric_handler(file, requests):
    matches = []
    file_content = file.chunks()
    # pattern = re.compile(rf"\b(?:\d\d[-.,/]\d\d[-.,/]\d\d\d\d|\d\d\d\d[-.,/]\d\d[-.,/]\d\d|\d\d[-.,/]\d\d[-.,/]\d\d)\b")
    pattern = re.compile(rf"\b[a-z]+[1-9]+\b")
    for line in file_content:

        matches+=(pattern.findall(line.decode()))

    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")

    # print(matches)
    return matches



# Dates


def all_dates_handler(file, requests):
    matches = []
    file_content = file.chunks()
    # pattern = re.compile(rf"\b(?:\d\d[-.,/]\d\d[-.,/]\d\d\d\d|\d\d\d\d[-.,/]\d\d[-.,/]\d\d|\d\d[-.,/]\d\d[-.,/]\d\d)\b")
    pattern = re.compile(rf"\b\d\d[-.,/]\d\d[-,./]\d\d\d\d|\d\d\d\d[-.,/]\d\d[-,./]\d\d\b|\d\d[-.,/]\d\d[-,./]\d\d\b")
    for line in file_content:

        matches+=(pattern.findall(line.decode()))

    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")

    # print(matches)
    return matches


# Phone Number Handler


def all_phone_handler(file, requests):
    matches = []
    file_content = file.chunks()
    pattern = re.compile(rf"\+?(?:[1-9]+)?[-,.\w(]?\d+[-.,\w)]?\d+[-.,\w]?\d+\b")
    for line in file_content:
        # matches += pattern.findall(line.decode())
        matches+=(pattern.findall(line.decode()))

    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")

    print(matches)
    return matches


def custom_phone_handler(file, requests):
    matches = []
    content = file.readlines()
    for i, j in requests.items():
        print(i, j)

    if (requests['EmailUsername']):
        letters = requests['EmailUsername']
        file_content = content
        if (('EmailStartingWithUsername' not in requests) and ('EmailEndingWithUsername' not in requests)):
            if ('EmailUsernameCase' in requests):
                pattern = re.compile(
                    rf'\b[a-zA-Z_.0-9%+-]*{letters}[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
            else:
                pattern = re.compile(
                    rf'\b[a-zA-Z_.0-9%+-]*{letters}[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*')
            for line in file_content:
                matches += pattern.findall(line.decode())
        else:

            if ('EmailStartingWithUsername' in requests):
                if ('EmailUsernameCase' in requests):
                    pattern = re.compile(
                        rf'\b{letters}+[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
                else:
                    pattern = re.compile(
                        rf'\b{letters}+[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*')
                for line in file_content:
                    matches += pattern.findall(line.decode())

            if ('EmailEndingWithUsername' in requests):
                if ('EmailUsernameCase' in requests):
                    pattern = re.compile(
                        rf'\b[a-zA-Z0-9_.]*{letters}@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
                else:
                    pattern = re.compile(
                        rf'\b[a-zA-Z0-9_.]*{letters}@[a-zA-Z]*\.[a-zA-Z]*')
                for line in file_content:
                    matches += pattern.findall(line.decode())

    if (requests['EmailDomain']):
        letters = requests['EmailDomain']
        file_content = content
        if ('EmailDomainCase' in requests):
            pattern = re.compile(
                rf'[a-zA-Z0-9_.]*@{letters}\.[a-zA-Z]*', re.IGNORECASE)
        else:
            pattern = re.compile(rf'[a-zA-Z0-9_.]*@{letters}\.[a-zA-Z]*')
        for line in file_content:
            matches += pattern.findall(line.decode())

    if (requests['EmailDotSomething']):
        letters = requests['EmailDotSomething']
        file_content = content
        if ('EmailDotSomethingCase' in requests):
            pattern = re.compile(
                rf'[a-zA-Z0-9_.]*@[a-zA-Z]*\.{letters}', re.IGNORECASE)
        else:
            pattern = re.compile(rf'[a-zA-Z0-9_.]*@[a-zA-Z]*\.{letters}')
        for line in file_content:
            matches += pattern.findall(line.decode())

    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")
    return matches


# URLs

def all_urls_handler(file, requests):
    matches = []
    file_content = file.chunks()
    pattern = re.compile(r"\b(?:https://|http://|ftp://)(?:\w+\.)?\w+\.\w+.\b")
    for line in file_content:
        matches += pattern.findall(line.decode(), re.IGNORECASE)
    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")
    return matches


def custom_urls_handler(file, requests):
    matches = []
    content = file.readlines()
    for i, j in requests.items():
        print(i, j)

    if (requests['EmailUsername']):
        letters = requests['EmailUsername']
        file_content = content
        if (('EmailStartingWithUsername' not in requests) and ('EmailEndingWithUsername' not in requests)):
            if ('EmailUsernameCase' in requests):
                pattern = re.compile(
                    rf'\b[a-zA-Z_.0-9%+-]*{letters}[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
            else:
                pattern = re.compile(
                    rf'\b[a-zA-Z_.0-9%+-]*{letters}[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*')
            for line in file_content:
                matches += pattern.findall(line.decode())
        else:

            if ('EmailStartingWithUsername' in requests):
                if ('EmailUsernameCase' in requests):
                    pattern = re.compile(
                        rf'\b{letters}+[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
                else:
                    pattern = re.compile(
                        rf'\b{letters}+[a-zA-Z0-9_.]*@[a-zA-Z]*\.[a-zA-Z]*')
                for line in file_content:
                    matches += pattern.findall(line.decode())

            if ('EmailEndingWithUsername' in requests):
                if ('EmailUsernameCase' in requests):
                    pattern = re.compile(
                        rf'\b[a-zA-Z0-9_.]*{letters}@[a-zA-Z]*\.[a-zA-Z]*', re.IGNORECASE)
                else:
                    pattern = re.compile(
                        rf'\b[a-zA-Z0-9_.]*{letters}@[a-zA-Z]*\.[a-zA-Z]*')
                for line in file_content:
                    matches += pattern.findall(line.decode())

    if (requests['EmailDomain']):
        letters = requests['EmailDomain']
        file_content = content
        if ('EmailDomainCase' in requests):
            pattern = re.compile(
                rf'[a-zA-Z0-9_.]*@{letters}\.[a-zA-Z]*', re.IGNORECASE)
        else:
            pattern = re.compile(rf'[a-zA-Z0-9_.]*@{letters}\.[a-zA-Z]*')
        for line in file_content:
            matches += pattern.findall(line.decode())

    if (requests['EmailDotSomething']):
        letters = requests['EmailDotSomething']
        file_content = content
        if ('EmailDotSomethingCase' in requests):
            pattern = re.compile(
                rf'[a-zA-Z0-9_.]*@[a-zA-Z]*\.{letters}', re.IGNORECASE)
        else:
            pattern = re.compile(rf'[a-zA-Z0-9_.]*@[a-zA-Z]*\.{letters}')
        for line in file_content:
            matches += pattern.findall(line.decode())

    if matches:
        return matches
    else:
        matches.append("Oops No such data Found.")
    return matches


# Custom Handler


def custom_handler(file, requests):
    matches = []
    content = file.readlines()
    for i, j in requests.items():
        print(i, "\t\t" + j)

    # Words containing group of letters Handler

    if (requests['Words_containing_group_of_letters']):
        letters = requests['Words_containing_group_of_letters']
        file_content = content
        if ("Words_containing_group_of_letters_CASE" in requests):
            pattern = re.compile(rf"\w*{letters}\w*", re.IGNORECASE)
        else:
            pattern = re.compile(rf"\w*{letters}\w*")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Words Having At least one letter Handler

    if (requests['Words_Having_At_least_one_letter']):
        letters = requests['Words_Having_At_least_one_letter']
        file_content = content
        if "Words_Having_At_least_one_letter_CASE" in requests:
            pattern = re.compile(rf"\b\w*[{letters}]+?\w*", re.IGNORECASE)
        else:
            pattern = re.compile(rf"\b\w*[{letters}]+?\w*")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Capital Letters Handler

    if (('CapitalLetters' in requests) and (requests['CapitalLetters'])):
        file_content = content
        if "CAPITAL_LETTERS_WORDS_fixed_or_range" in requests and requests[
            "CAPITAL_LETTERS_WORDS_fixed_or_range"] == "fixed":
            fixed_length = requests['CAPITAL_LETTERS_WORDS_fixed_length']
            pattern = re.compile(r"\b[A-Z]{" + fixed_length + r"}\b")
        elif "CAPITAL_LETTERS_WORDS_fixed_or_range" in requests and requests[
            "CAPITAL_LETTERS_WORDS_fixed_or_range"] == "range":
            range_from = requests["CAPITAL_LETTERS_WORDS_from"]
            range_to = requests["CAPITAL_LETTERS_WORDS_to"]
            pattern = re.compile(r"\b[A-Z]{" + range_from + r"," + range_to + r"}\b")
        else:
            pattern = re.compile(rf"\b[A-Z]+?[A-Z]+\b")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Small letters handler

    if (('SmallLetters' in requests) and (requests['SmallLetters'])):
        file_content = content
        if "small_letters_words_fixed_or_range" in requests and requests[
            "small_letters_words_fixed_or_range"] == "fixed":
            fixed_length = requests['small_letters_words_fixed_length']
            pattern = re.compile(r"\b[a-z]{" + fixed_length + r"}\b")
        elif "small_letters_words_fixed_or_range" in requests and requests[
            "small_letters_words_fixed_or_range"] == "range":
            range_from = requests["small_letters_words_from"]
            range_to = requests["small_letters_words_to"]
            pattern = re.compile(r"\b[a-z]{" + range_from + r"," + range_to + r"}\b")
        else:
            pattern = re.compile(rf"\b[a-z]+?[a-z]+\b")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Only First Letter Capital

    if (("OnlyFirstLetter" in requests) and (requests["OnlyFirstLetter"])):
        file_content = content
        if "Only_First_Letter_Capital_Words_fixed_or_range" in requests and requests[
            "Only_First_Letter_Capital_Words_fixed_or_range"] == "fixed":
            fixed_length = requests['Only_First_Letter_Capital_Words_fixed_length']
            print(fixed_length)
            pattern = re.compile(r"\b[A-Z][a-z]{" + fixed_length + r"}\b")
        elif "Only_First_Letter_Capital_Words_fixed_or_range" in requests and requests[
            "Only_First_Letter_Capital_Words_fixed_or_range"] == "range":
            range_from = requests["Only_First_Letter_Capital_Words_from"]
            range_to = requests["Only_First_Letter_Capital_Words_to"]
            pattern = re.compile(
                r"\b[A-Z][a-z]{" + range_from + r"," + range_to + r"}\b")
        else:
            pattern = re.compile(rf"\b[A-Z][a-z]+?[a-z]+\b")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Numeric Words Handler

    if (("numeric" in requests) and (requests["numeric"])):
        file_content = content
        if "numeric_words_fixed_or_range" in requests and requests["numeric_words_fixed_or_range"] == "fixed":
            fixed_length = requests['numeric_words_fixed_length']
            print(fixed_length)
            pattern = re.compile(r"\b[0-9]{" + fixed_length + r"}\b")
        elif "numeric_words_fixed_or_range" in requests and requests["numeric_words_fixed_or_range"] == "range":
            range_from = requests["numeric_words_from"]
            range_to = requests["numeric_words_to"]
            pattern = re.compile(r"\b[0-9]{" + range_from + r"," + range_to + r"}\b")
        else:
            pattern = re.compile(rf"\b[0-9]+?[0-9]+\b")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Words Starting with letters Handler

    if (requests['Words_Starting_with_letters']):
        letters = requests['Words_Starting_with_letters']
        file_content = content
        if "Words_Starting_with_letters_CASE" in requests:
            pattern = re.compile(rf"\b{letters}+?\w*", re.IGNORECASE)
        else:
            pattern = re.compile(rf"\b{letters}+?\w*")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Words Not Starting with letters Handler

    if (requests['Words_Not_Starting_with_letters']):
        letters = requests['Words_Not_Starting_with_letters']
        file_content = content
        if "Words_Not_Starting_with_letters_CASE" in requests:
            pattern = re.compile(rf"^{letters}", re.IGNORECASE)
        else:
            pattern = re.compile(rf"^{letters}")
        for line in file_content:
            words = re.findall(r"\b\w+\b", line.decode())
            for word in words:
                match = pattern.findall(word)
                if (match):
                    continue
                else:
                    pattern = re.compile(r'\b\w+\b')
                    matches += pattern.findall(word)

    # Words Ending with letters Handler

    if (requests['Words_Ending_with_letters']):
        letters = requests['Words_Ending_with_letters']
        file_content = content
        if "Words_Ending_with_letters_CASE" in requests:
            pattern = re.compile(rf"\w*{letters}", re.IGNORECASE)
        else:
            pattern = re.compile(rf"\w*{letters}")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Words Not Ending with letters Handler

    if (requests['Words_Not_Ending_with_letters']):
        letters = requests['Words_Not_Ending_with_letters']
        file_content = content
        if "Words_Not_Ending_with_letters_CASE" in requests:
            pattern = re.compile(rf"{letters}$", re.IGNORECASE)
        else:
            pattern = re.compile(rf"{letters}$")
        for line in file_content:
            words = re.findall(r"\b\w+\b", line.decode())
            for word in words:
                match = pattern.findall(word)
                if (match):
                    continue
                else:
                    pattern = re.compile(r'\b\w+\b')
                    matches += pattern.findall(word)

    # Words of Particular letters Handler

    if (requests['Words_of_Particular_letters']):
        letters = requests['Words_of_Particular_letters']
        file_content = content
        if "Words_of_Particular_letters_CASE" in requests:
            pattern = re.compile(rf"\b[{letters}]+\b", re.IGNORECASE)
        else:
            pattern = re.compile(rf"\b[{letters}]+\b")
        for line in file_content:
            matches += pattern.findall(line.decode())

    # Words Excluding letters Handler

    if (requests['Words_Excluding_letters']):
        letters = requests['Words_Excluding_letters']
        file_content = content
        if "Words_Excluding_letters_CASE" in requests:
            pattern = re.compile(rf"\b[^{letters}]+\b", re.IGNORECASE)
        else:
            pattern = re.compile(rf"\b[^{letters}]+\b")
        for line in file_content:
            matches += pattern.findall(line.decode())

    if matches:
        return matches
    else:
        matches.append("Invalid Request")
    return matches

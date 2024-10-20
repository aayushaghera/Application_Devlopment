class WelcomePage extends StatefulWidget {
  const WelcomePage({super.key});

    @override
    State<WelcomePage> createState() => _WelcomePageState();
}

class _WelcomePageState extends State<WelcomePage> {
    List images = [
            "Whitewall1.jpeg",
            "Whitewall2.jpeg",
            "Whitewall3.jpeg"
            ];

    @override
    Widget build(BuildContext context) {
        return Scaffold(
                body: PageView.builder(
                scrollDirection: Axis.vertical,
                itemCount: images.length,
                itemBuilder: (_, index) {
            return Container(
                    width: double.maxFinite,
                    height: double.maxFinite,
                    decoration: BoxDecoration(
                    image: DecorationImage(
                    image: AssetImage("images/" + images[index]),
                    fit: BoxFit.cover,
              ),
            ),
            child: Container(
                    margin: EdgeInsets.only(top: 150, left: 20, right: 20),
            child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
            Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
            Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: AppLargeText(
                    text: "CarsMania",
                    color: AppColors.darkmain,
                        ),
                      ),
            Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: AppText(
                    text: "Discover",
                    size: 30,
                    color: AppColors.mainColor,
                        ),
                      ),
            Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Container(
                    width: 250,
                    child: AppText(
                    text: "Get to know about your favourite dream car!!!",
                    color: AppColors.textColor2,
                          ),
                        ),
                      ),
            Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: InkWell(
                    onTap: () {
                runApp(HomePage());
            },
            child: InkWell(
                    child: Container(
                    child: ResponsiveButton(
                    btntext: "Go!!!",
                    width: 90,
                              ),
                            ),
            onTap: () {
                Navigator.of(context).pushReplacement(
                        MaterialPageRoute(
                                builder: (BuildContext context) =>
                MainPage(),
                                ),
                              );
            },
                          ),
                        ),
                      ),
                    ],
                  ),
            Padding(
                    padding: const EdgeInsets.only(right: 10),
            child: Column(
                    children: List.generate(3, (indexdots) {
            return Container(
                    margin: EdgeInsets.only(top: 3, bottom: 3),
            width: 8,
                    height: index == indexdots ? 25 : 8,
                    decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(8),
                    color: index == indexdots
                    ? AppColors.mainColor
                    : AppColors.textColor2,
                          ),
                        );
                      }),
                    ),
                  ),
                ],
              ),
            ),
          );
        },
      ),
    );
    }
}
